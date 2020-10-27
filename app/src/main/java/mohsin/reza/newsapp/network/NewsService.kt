package mohsin.reza.newsapp.network

import io.reactivex.Observable
import mohsin.reza.newsapp.network.model.Article
import retrofit2.http.GET

interface NewsService {
    @GET("1/coding_test/13ZZQX/full")
    fun getNewsData(): Observable<Article>
}