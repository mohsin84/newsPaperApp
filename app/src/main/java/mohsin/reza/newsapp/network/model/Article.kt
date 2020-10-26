package mohsin.reza.newsapp.network.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Article(
    @Json(name = "id") val id: Int? = null,
    @Json(name = "categories") val categories: List<String>? = null,
    @Json(name = "authors") val authors: List<String>? = null,
    @Json(name = "url") val url: String? = null,
    @Json(name = "lastModified") val lastModified: Long? = null,
    @Json(name = "onTime") val onTime: Long? = null,
    @Json(name = "sponsored") val sponsored: Boolean? = null,
    @Json(name = "displayName") val displayName: String? = null,
    @Json(name = "assets") val assets: List<Asset>? = null
) : Parcelable