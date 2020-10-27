package mohsin.reza.newsapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Observable
import mohsin.reza.newsapp.network.NewsRepository
import mohsin.reza.newsapp.network.model.Asset
import mohsin.reza.newsapp.network.model.RelatedImages
import mohsin.reza.newsapp.ui.HomePageVM
import mohsin.reza.newsapp.utils.ConnectionUtil
import mohsin.reza.newsapp.utils.OffLineConnectionException
import mohsin.reza.newsapp.utils.safeSize
import mohsin.reza.newsapp.utils.scheduler.TestSchedulers
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Response

class HomePageVMTest {
    private val mediaTypeJson = "application/json".toMediaTypeOrNull()

    private val newsRepositoryMock = mockk<NewsRepository>()

    private val connectionUtilMock = mockk<ConnectionUtil>()

    private val viewModel = HomePageVM(newsRepositoryMock, TestSchedulers())

    private val image1 = RelatedImages(width = 375, url = "size375")
    private val image2 = RelatedImages(width = 600, url = "seze600")
    private val image3 = RelatedImages(width = 900, url = "size900")
    private val image4 = RelatedImages(width = 1080, url = "size1080")

    private val asset1 =
        Asset(headline = "First asset", timeStamp = 5, relatedImages = listOf(image1, image4))
    private val asset2 =
        Asset(headline = "Second asset", timeStamp = 3, relatedImages = listOf(image2, image3))
    private val asset3 = Asset(
        headline = "Third asset",
        timeStamp = 4,
        relatedImages = listOf(image4, image2, image1, image3)
    )
    private val asset4 =
        Asset(headline = "Fourth asset", timeStamp = 1, relatedImages = listOf(image1, image3))
    private val asset5 =
        Asset(headline = "Fifth asset", timeStamp = 2, relatedImages = listOf(image2, image4))

    private val resultsValid = listOf(asset1, asset2, asset3, asset4, asset5)
    private val resultsEmpty = listOf<Asset>()
    private val noInternetException = OffLineConnectionException()

    private val error = HttpException(
        Response.error<String>(400, "content".toResponseBody(mediaTypeJson))
    )

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Test
    fun givenRepositoryReturnsValidList_whenDataRequested_thenReturnSuccessState() {
        // given
        every { connectionUtilMock.hasInternet() } returns true
        every { newsRepositoryMock.getAssetList() } returns Observable.just(resultsValid)

        // when
        viewModel.requestArticleList()

        // then
        viewModel.movieListLiveData.observeForever {
            // check data size
            assertEquals(resultsValid.size, it.data.safeSize)

            // check if the list is sorted based on timestamp field
            assertEquals(it.data?.get(0)?.headline, "First asset")
            assertEquals(it.data?.get(2)?.headline, "Second asset")
            assertEquals(it.data?.get(4)?.headline, "Fourth asset")

            // check if smallest related image is stored in imageURL
            assertEquals(it.data?.get(1)?.imageUrl, image1.url)
        }
    }

    @Test
    fun givenRepositoryReturnsEmptyList_whenDataExecuted_thenReturnEmptyState() {
        // given
        every { connectionUtilMock.hasInternet() } returns true
        every { newsRepositoryMock.getAssetList() } returns Observable.just(resultsEmpty)

        // when
        viewModel.requestArticleList()

        // then look for empty List
        viewModel.movieListLiveData.observeForever {
            assert(it.data?.isEmpty() == true)
        }
    }

    @Test
    fun givenRepositoryReturnsError_whenDataRequested_thenReturnErrorState() {
        // given
        every { connectionUtilMock.hasInternet() } returns true
        every { newsRepositoryMock.getAssetList() } returns Observable.error(error)

        // when
        viewModel.requestArticleList()

        // then
        viewModel.movieListLiveData.observeForever {
            assertEquals(error, it.error)
        }
    }

    @Test
    fun givenNoInternetConnection_whenDataRequested_thenReturnNoConnectionError() {
        // given
        every { connectionUtilMock.hasInternet() } returns false
        every { newsRepositoryMock.getAssetList() } returns Observable.error(noInternetException)

        // when
        viewModel.requestArticleList()

        // then
        viewModel.movieListLiveData.observeForever {
            assert(it.error is OffLineConnectionException)
        }
    }
}