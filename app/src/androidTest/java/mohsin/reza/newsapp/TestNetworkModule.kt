package mohsin.reza.newsapp

import android.app.Application
import mohsin.reza.newsapp.di.NetworkModule
import mohsin.reza.newsapp.network.NetworkSettings

class TestNetworkModule(app: Application) : NetworkModule(app) {
    override fun provideNetworkSettings(): NetworkSettings {
        return TestNetworkSettingsImpl()
    }
}
