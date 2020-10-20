package mohsin.reza.newsapp.di

import dagger.Component
import mohsin.reza.newsapp.MainActivity

import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        NavigationModule::class
    ]
)
interface AppComponent {
    fun inject(activity: MainActivity)
}
