package mohsin.reza.newsapp.network

import io.reactivex.Observable
import mohsin.reza.newsapp.network.model.Article
import retrofit2.http.GET
import retrofit2.http.Url

interface NewsService {
    @GET
    fun getNewsData(@Url url: String): Observable<Article>
}