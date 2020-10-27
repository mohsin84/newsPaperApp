package mohsin.reza.newsapp.di

import android.app.Application
import android.content.Context
import android.content.res.Resources
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import mohsin.reza.newsapp.network.MockInterceptor
import mohsin.reza.newsapp.network.NetworkSettings
import mohsin.reza.newsapp.network.NetworkSettingsImpl
import mohsin.reza.newsapp.network.NewsRepository
import mohsin.reza.newsapp.network.NewsService
import mohsin.reza.newsapp.utils.scheduler.AppSchedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Network Module
 */
@Module
open class NetworkModule(val application: Application) {

    companion object {
        private const val PREFERENCES_NAME = "Network"
        private const val BASE_URL = "https://bruce-v2-mob.fairfaxmedia.com.au/"
        private const val TIMEOUT = 3L
    }

    private inline fun <reified T> Retrofit.createApi(): T = create(T::class.java)

    @Singleton
    @Provides
    fun provideRxJava2CallAdapterFactory(): RxJava2CallAdapterFactory =
        RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())

    @Singleton
    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder().build()

    @Singleton
    @Provides
    fun provideMoshiConverterFactory(moshi: Moshi): MoshiConverterFactory =
        MoshiConverterFactory.create(moshi).asLenient()

    @Singleton
    @Provides
    open fun provideNetworkSettings(): NetworkSettings = NetworkSettingsImpl()

    @Singleton
    @Provides
    fun provideMockInterceptor(networkSettings: NetworkSettings): MockInterceptor {
        return MockInterceptor(networkSettings)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        mockInterceptor: MockInterceptor
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.connectTimeout(TIMEOUT, TimeUnit.SECONDS)
        builder.writeTimeout(TIMEOUT, TimeUnit.SECONDS)
        builder.readTimeout(TIMEOUT, TimeUnit.SECONDS)
        builder.addInterceptor(mockInterceptor)
        return builder.build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        httpClient: OkHttpClient,
        rxJava2CallAdapterFactory: RxJava2CallAdapterFactory,
        moshiConverterFactory: MoshiConverterFactory
    ): Retrofit = Retrofit.Builder()
        .addCallAdapterFactory(rxJava2CallAdapterFactory)
        .addConverterFactory(moshiConverterFactory)
        .baseUrl(BASE_URL)
        .client(httpClient)
        .build()

    @Provides
    @Singleton
    fun providesResources(): Resources = application.resources

    @Singleton
    @Provides
    fun providePreferences() =
        application.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)!!

    @Singleton
    @Provides
    fun provideNewsService(retrofit: Retrofit): NewsService = retrofit.createApi()

    @Singleton
    @Provides
    fun provideNewsRepository(
        newsService: NewsService
    ) = NewsRepository(newsService)

    @Singleton
    @Provides
    fun providesAppSchedulers(): mohsin.reza.newsapp.utils.scheduler.Schedulers = AppSchedulers()
}