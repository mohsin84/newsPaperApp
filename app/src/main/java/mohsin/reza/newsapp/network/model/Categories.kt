package mohsin.reza.newsapp.network.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Categories(
    @Json(name = "name") val name: String,
    @Json(name = "sectionPath") val sectionPath: String,
    @Json(name = "orderNum") val orderNum: Int
) : Parcelable