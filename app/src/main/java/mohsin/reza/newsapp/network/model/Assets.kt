package mohsin.reza.newsapp.network.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
class Assets(
    @Json(name = "headline") val headline: String,
    @Json(name = "theAbstract") val theAbstract: String,
    @Json(name = "byLine") val byLine: String,
    @Json(name = "url") val url: String,
    @Json(name = "relatedImages") val relatedImages: List<RelatedImages>
) : Parcelable