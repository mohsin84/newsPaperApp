package mohsin.reza.newsapp.network.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Overrides(
    @Json(name = "overrideHeadline") val overrideHeadline: String,
    @Json(name = "overrideAbstract") val overrideAbstract: String
) : Parcelable