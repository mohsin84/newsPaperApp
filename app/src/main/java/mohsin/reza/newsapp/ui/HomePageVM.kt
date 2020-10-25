package mohsin.reza.newsapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import mohsin.reza.newsapp.di.Resource
import mohsin.reza.newsapp.network.NewsRepository
import mohsin.reza.newsapp.network.model.Asset
import mohsin.reza.newsapp.utils.scheduler.Schedulers
import javax.inject.Inject

class HomePageVM @Inject constructor(
    private val newsRepository: NewsRepository,
    private val schedulers: Schedulers
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val movieListMutableLiveData = MutableLiveData<Resource<List<Asset>>>()

    val movieListLiveData: LiveData<Resource<List<Asset>>>
        get() = movieListMutableLiveData

    fun requestArticleList() {
        newsRepository.getAssetList()
            .map { list ->
                // sorting by timeStamp
                list.sortedByDescending { asset ->
                    // finding and storing the smallest imageSize
                    val imageUrl = asset.relatedImages?.minBy { it.width ?: Int.MAX_VALUE }
                    asset.imageUrl = imageUrl?.url
                    asset.timeStamp
                }
            }
            .subscribeOn(schedulers.main())
            .doOnSubscribe {
                movieListMutableLiveData.postValue(Resource.loading())
            }
            .doOnError { e ->
                movieListMutableLiveData.postValue(Resource.error(e))
            }
            .subscribe {
                movieListMutableLiveData.postValue(Resource.success(it))
            }.addTo(compositeDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}