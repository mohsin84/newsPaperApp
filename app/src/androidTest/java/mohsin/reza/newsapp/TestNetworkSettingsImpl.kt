package mohsin.reza.newsapp

import mohsin.reza.newsapp.network.NetworkSettings

class TestNetworkSettingsImpl : NetworkSettings {
    override var isInMockMode = true
    override var isConnectedToInternet: Boolean = true
}
