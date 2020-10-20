package mohsin.reza.newsapp.di

import dagger.Module
import dagger.Provides
import mohsin.reza.newsapp.utils.Navigator
import javax.inject.Singleton

@Module
class NavigationModule {
    @Provides
    @Singleton
    fun providesNavigator(): Navigator = Navigator()
}