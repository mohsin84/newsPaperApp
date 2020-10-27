package mohsin.reza.newsapp.network

import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

class MockInterceptor(private val networkSettings: NetworkSettings) : Interceptor {
    companion object {
        private const val RESPONSE_200 = 200
        private const val RESPONSE_504 = 504
        private const val ARTICLE_PATH = "/1/coding_test/13ZZQX/full"
        private val mediaTypeJson = "application/json".toMediaTypeOrNull()
        private val errorResponse = { request: Request ->
            Response.Builder()
                .body("error".toResponseBody(mediaTypeJson))
                .request(request)
                .protocol(Protocol.HTTP_2)
                .code(RESPONSE_504)
                .message("")
                .build()
        }

        private val successResponse = { request: Request ->
            val mockJson: String = FileReader.readStringFromFile("news_article.json")
            Response.Builder()
                .body(mockJson.toResponseBody(mediaTypeJson))
                .request(request)
                .protocol(Protocol.HTTP_2)
                .code(RESPONSE_200)
                .message("")
                .build()
        }
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val encodedPath = request.url.encodedPath
        return when {
            !networkSettings.isInMockMode -> { // this will be only true when run via EspressoTestRunner
                chain.proceed(request)
            }
            encodedPath == ARTICLE_PATH -> {
                if (networkSettings.isConnectedToInternet) {
                    successResponse(request)
                } else {
                    errorResponse(request)
                }
            }
            else -> {
                chain.proceed(request)
            }
        }
    }
}