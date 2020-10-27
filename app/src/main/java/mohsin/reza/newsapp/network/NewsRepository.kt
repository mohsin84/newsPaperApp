package mohsin.reza.newsapp.network

import io.reactivex.Observable
import mohsin.reza.newsapp.network.model.Asset

class NewsRepository(private val newsService: NewsService) {
    fun getAssetList(): Observable<List<Asset>> {
        return newsService.getNewsData().map { it.assets ?: emptyList() } ?: Observable.just(
            emptyList()
        )
    }
}