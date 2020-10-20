package mohsin.reza.newsapp.network.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
class RelatedImages(
    @Json(name = "id") val id: Int,
    @Json(name = "categories") val categories: List<String>,
    @Json(name = "brands") val brands: List<String>,
    @Json(name = "authors") val authors: List<String>,
    @Json(name = "url") val url: String,
    @Json(name = "lastModified") val lastModified: Int,
    @Json(name = "sponsored") val sponsored: Boolean,
    @Json(name = "description") val description: String,
    @Json(name = "photographer") val photographer: String,
    @Json(name = "type") val type: String,
    @Json(name = "width") val width: Int,
    @Json(name = "height") val height: Int,
    @Json(name = "assetType") val assetType: String,
    @Json(name = "xLarge@2x") val xLargeTx: String,
    @Json(name = "xLarge") val xLarge: String,
    @Json(name = "large@2x") val largeTx: String,
    @Json(name = "large") val large: String,
    @Json(name = "thumbnail@2x") val thumbnailTx: String,
    @Json(name = "thumbnail") val thumbnail: String,
    @Json(name = "timeStamp") val timeStamp: Int
) : Parcelable