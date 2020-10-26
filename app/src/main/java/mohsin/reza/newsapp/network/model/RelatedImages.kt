package mohsin.reza.newsapp.network.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
class RelatedImages(
    @Json(name = "id") val id: Int? = null,
    @Json(name = "categories") val categories: List<String>? = null,
    @Json(name = "brands") val brands: List<String>? = null,
    @Json(name = "authors") val authors: List<String>? = null,
    @Json(name = "url") val url: String? = null,
    @Json(name = "lastModified") val lastModified: Long? = null,
    @Json(name = "sponsored") val sponsored: Boolean? = null,
    @Json(name = "description") val description: String? = null,
    @Json(name = "photographer") val photographer: String? = null,
    @Json(name = "type") val type: String? = null,
    @Json(name = "width") val width: Int? = null,
    @Json(name = "height") val height: Int? = null,
    @Json(name = "assetType") val assetType: String? = null,
    @Json(name = "xLarge2x") val xLargeTx: String? = null,
    @Json(name = "xLarge") val xLarge: String? = null,
    @Json(name = "large2x") val largeTx: String? = null,
    @Json(name = "large") val large: String? = null,
    @Json(name = "thumbnail2x") val thumbnailTx: String? = null,
    @Json(name = "thumbnail") val thumbnail: String? = null,
    @Json(name = "timeStamp") val timeStamp: Long? = null
) : Parcelable