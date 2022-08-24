package com.app.androidev.app.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class StarListItem(

    @Json(name = "name")
    val name: String? = null,

    @Json(name = "id")
    val id: String? = null
) : Parcelable