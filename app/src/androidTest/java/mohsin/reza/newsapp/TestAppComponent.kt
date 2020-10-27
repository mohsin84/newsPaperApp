package mohsin.reza.newsapp

import dagger.Component
import mohsin.reza.newsapp.di.AppComponent
import mohsin.reza.newsapp.di.AppModule
import mohsin.reza.newsapp.di.NavigationModule
import mohsin.reza.newsapp.di.NetworkModule
import mohsin.reza.newsapp.home.HomeFragmentTest
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        NavigationModule::class
    ]
)
interface TestAppComponent : AppComponent {
    fun inject(fragment: HomeFragmentTest)
}