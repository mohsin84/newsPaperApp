package mohsin.reza.newsapp.network.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class RelatedAssets(
    @Json(name = "id") val id: Int,
    @Json(name = "categories") val categories: List<Categories>,
    @Json(name = "authors") val authors: List<Authors>,
    @Json(name = "url") val url: String,
    @Json(name = "lastModified") val lastModified: Int,
    @Json(name = "onTime") val onTime: Int,
    @Json(name = "sponsored") val sponsored: Boolean,
    @Json(name = "assetType") val assetType: String,
    @Json(name = "headline") val headline: String,
    @Json(name = "timeStamp") val timeStamp: Int
) : Parcelable