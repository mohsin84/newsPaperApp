package mohsin.reza.newsapp.network.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
class Asset(
    @Json(name = "id") val id: Int? = null,
    @Json(name = "categories") val categories: List<Categories>? = null,
    @Json(name = "authors") val authors: List<Authors>? = null,
    @Json(name = "url") val url: String? = null,
    @Json(name = "lastModified") val lastModified: Long? = null,
    @Json(name = "sponsored") val sponsored: Boolean? = null,
    @Json(name = "headline") val headline: String? = null,
    @Json(name = "indexHeadline") val indexHeadline: String? = null,
    @Json(name = "tabletHeadline") val tabletHeadline: String? = null,
    @Json(name = "theAbstract") val theAbstract: String? = null,
    @Json(name = "byLine") val byLine: String? = null,
    @Json(name = "acceptComments") val acceptComments: Boolean? = null,
    @Json(name = "numberOfComments") val numberOfComments: Int? = null,
    @Json(name = "relatedAssets") val relatedAssets: List<RelatedAssets>? = null,
    @Json(name = "relatedImages") val relatedImages: List<RelatedImages>? = null,
    @Json(name = "relatedImages") var imageUrl: String? = null,
    @Json(name = "signPost") val signPost: String? = null,
    @Json(name = "sources") val sources: List<Sources>? = null,
    @Json(name = "assetType") val assetType: String? = null,
    @Json(name = "overrides") val overrides: Overrides? = null,
    @Json(name = "timeStamp") val timeStamp: Long? = null
) : Parcelable