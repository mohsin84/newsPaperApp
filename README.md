# newsPaperApp
<div align="center">
    <img src="https://github.com/mohsin84/newsPaperApp/blob/main/news_app.gif" width="480px"</img> 
</div>

This app get data from  give api</a> and show popular movie items in a list of news article. Clicking any of the tile will open a AFR webpage with the full article. It’s a complete MVVM project that use dependency injection
and lifecycle aware components. It use all features of <a href="https://developer.android.com/topic/libraries/architecture/index.html">
Android Architecture Components</a> library like Room, ViewModels, LiveData and other Lifecycle-aware components.

I used <a href="https://google.github.io/dagger/">Dagger 2 </a>Dependency Injection in this project to manage dependencies, simplified 
acces to shared dependency like use of <a href="http://square.github.io/retrofit/"> Retrofit</a> to make asynchronous API calls,
also for scope instances like Singleton repositories. Inside fragment used Livedata to observe data changes in ViewModel. Used the repository to maintain separation of concern and also to keep the ViewModel lean. Converstion of rx stream to liveData is done in the viewModel.

Lazy Image loading is achieved using <a href="http://bumptech.github.io/glide/">Glide</a> library. By deafult all images will be loaded to memory. Disk cache is also possible with few strategy for caching (did not added any disk cache in this project).

Added few Unit test for the viewModel and espresso ui test

<b>List of android libraries used</b>
<ol>
  <li><a href="https://developer.android.com/topic/libraries/architecture/index.html">Android Architecture Components</a></li>
  <li><a href="https://google.github.io/dagger/">Dagger 2 </a> </li>  
  <li><a href="https://developer.android.com/training/testing/espresso/index.html"> Espresso </a></li>  
</ol>

<b>List of 3rd Party libraries</b>
<ol>
  <li> <a href="https://github.com/ReactiveX/RxAndroid"> RxAndroid</a></li>
  <li> <a href="http://square.github.io/retrofit/"> Retrofit</a></li>
  <li> <a href="https://square.github.io/okhttp/"> OkHttp</a></li>
  <li> <a href="http://bumptech.github.io/glide/"> Glide </a></li>
  <li> <a href="https://mockk.io/"> Mockk</a></li> 
  <li> <a href="https://github.com/square/moshi"> Moshi</a></li> 
</ol>

Coding architecture/ Design Pattern:
 <ol>
<li> <a href="https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel">MVVM (Model View ViewModel)</a></li>
</ol>
