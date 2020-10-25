package mohsin.reza.newsapp.network.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Article(
    @Json(name = "id") val id: Int,
    @Json(name = "categories") val categories: List<String>,
    @Json(name = "authors") val authors: List<String>,
    @Json(name = "url") val url: String,
    @Json(name = "lastModified") val lastModified: Long,
    @Json(name = "onTime") val onTime: Long,
    @Json(name = "sponsored") val sponsored: Boolean,
    @Json(name = "displayName") val displayName: String,
    @Json(name = "assets") val assets: List<Asset>
) : Parcelable