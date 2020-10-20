package mohsin.reza.newsapp.di

import android.app.Application
import android.content.Context
import android.content.res.Resources
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
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
open class NetworkModule(val application: Application, private val versionName: String? = null) {

    companion object {
        private const val PREFERENCES_NAME = "Network"
        // Used for Retrofit initialization only
        private const val BASE_URL =
            "https://bruce-v2-mob.fairfaxmedia.com.au/1/coding_test/13ZZQX/full"
        private const val TIMEOUT = 3L
    }

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

    @Singleton
    @Provides
    fun provideOkHttpClient(
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.connectTimeout(TIMEOUT, TimeUnit.SECONDS)
        builder.writeTimeout(TIMEOUT, TimeUnit.SECONDS)
        builder.readTimeout(TIMEOUT, TimeUnit.SECONDS)
        return builder.build()
    }

    @Provides
    @Singleton
    fun providesResources(): Resources = application.resources

    private inline fun <reified T> Retrofit.createApi(): T = create(T::class.java)

    @Singleton
    @Provides
    fun providePreferences() =
        application.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)!!

}