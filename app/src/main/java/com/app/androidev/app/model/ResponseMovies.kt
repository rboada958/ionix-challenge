package com.app.androidev.app.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResponseMovies(

    @Json(name = "errorMessage")
    val errorMessage: String? = null,

    @Json(name = "items")
    val items: List<MovieItem?>? = null
) : Parcelable