package com.app.androidev.app.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class GenreListItem(

    @Json(name = "value")
    val value: String? = null,

    @Json(name = "key")
    val key: String? = null
) : Parcelable