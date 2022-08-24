package com.app.androidev.ui.home.mvvm

import com.app.androidev.app.model.ResponseMovies
import com.app.androidev.utils.base.DataState
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun getMovies() : Flow<DataState<ResponseMovies?>>

}