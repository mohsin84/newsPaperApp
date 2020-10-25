package mohsin.reza.newsapp.network.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
class Asset(
    @Json(name = "id") val id: Int?,
    @Json(name = "categories") val categories: List<Categories>?,
    @Json(name = "authors") val authors: List<Authors>?,
    @Json(name = "url") val url: String?,
    @Json(name = "lastModified") val lastModified: Long?,
    @Json(name = "sponsored") val sponsored: Boolean?,
    @Json(name = "headline") val headline: String?,
    @Json(name = "indexHeadline") val indexHeadline: String?,
    @Json(name = "tabletHeadline") val tabletHeadline: String?,
    @Json(name = "theAbstract") val theAbstract: String?,
    @Json(name = "byLine") val byLine: String?,
    @Json(name = "acceptComments") val acceptComments: Boolean?,
    @Json(name = "numberOfComments") val numberOfComments: Int?,
    @Json(name = "relatedAssets") val relatedAssets: List<RelatedAssets>?,
    @Json(name = "relatedImages") val relatedImages: List<RelatedImages>?,
    @Json(name = "relatedImages") var imageUrl: String?,
    @Json(name = "signPost") val signPost: String?,
    @Json(name = "sources") val sources: List<Sources>?,
    @Json(name = "assetType") val assetType: String?,
    @Json(name = "overrides") val overrides: Overrides?,
    @Json(name = "timeStamp") val timeStamp: Long?
) : Parcelable