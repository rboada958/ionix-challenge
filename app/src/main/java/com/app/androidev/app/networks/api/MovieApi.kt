package com.app.androidev.app.networks.api

import com.app.androidev.app.model.ResponseMovies
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("/movies.json")
    suspend fun getMovies(@Query("key") key: String) : ApiResponse<ResponseMovies>
}