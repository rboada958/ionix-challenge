package com.app.androidev.app.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieItem(

    @Json(name = "image")
    val image: String? = null,

    @Json(name = "fullTitle")
    val fullTitle: String? = null,

    @Json(name = "runtimeMins")
    val runtimeMins: String? = null,

    @Json(name = "year")
    val year: String? = null,

    @Json(name = "directors")
    val directors: String? = null,

    @Json(name = "genreList")
    val genreList: List<GenreListItem?>? = null,

    @Json(name = "metacriticRating")
    val metacriticRating: String? = null,

    @Json(name = "directorList")
    val directorList: List<DirectorListItem?>? = null,

    @Json(name = "stars")
    val stars: String? = null,

    @Json(name = "title")
    val title: String? = null,

    @Json(name = "imDbRating")
    val imDbRating: String? = null,

    @Json(name = "runtimeStr")
    val runtimeStr: String? = null,

    @Json(name = "imDbRatingCount")
    val imDbRatingCount: String? = null,

    @Json(name = "plot")
    val plot: String? = null,

    @Json(name = "genres")
    val genres: String? = null,

    @Json(name = "contentRating")
    val contentRating: String? = null,

    @Json(name = "starList")
    val starList: List<StarListItem?>? = null,

    @Json(name = "id")
    val id: String? = null,

    @Json(name = "releaseState")
    val releaseState: String? = null
) : Parcelable