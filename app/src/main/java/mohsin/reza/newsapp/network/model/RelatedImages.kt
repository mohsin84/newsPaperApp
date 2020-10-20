package mohsin.reza.newsapp.network.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
class RelatedImages(
    @Json(name = "width") val width: String,
    @Json(name = "xLarge") val xLarge: String,
    @Json(name = "type") val type: String,
    @Json(name = "url") val url: String,
    @Json(name = "height") val height: String,
    @Json(name = "large") val large: String
) : Parcelable