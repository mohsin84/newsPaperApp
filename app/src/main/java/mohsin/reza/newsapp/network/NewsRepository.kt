package mohsin.reza.newsapp.network

import io.reactivex.Observable
import mohsin.reza.newsapp.network.model.Asset


class NewsRepository(private val newsService: NewsService) {
    companion object {
        private const val baseURL =
            "https://bruce-v2-mob.fairfaxmedia.com.au/1/coding_test/13ZZQX/full"
    }

    fun getAssetList(): Observable<List<Asset>> {
        return newsService.getNewsData(baseURL).map { it.assets ?: emptyList() } ?: Observable.just(
            emptyList()
        )
    }
}