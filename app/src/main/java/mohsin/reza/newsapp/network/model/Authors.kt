package mohsin.reza.newsapp.network.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Authors(
    @Json(name = "name") val name: String?,
    @Json(name = "title") val title: String?,
    @Json(name = "email") val email: String?,
    @Json(name = "relatedAssets") val relatedAssets: List<String>?,
    @Json(name = "relatedImages") val relatedImages: List<RelatedImages>?
) : Parcelable