package com.app.androidev.ui.home.mvvm

import com.app.androidev.app.model.ResponseMovies
import com.app.androidev.app.networks.api.MovieApi
import com.app.androidev.utils.base.DataState
import com.app.androidev.utils.runRemoteApiCall
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: MovieApi
) : MovieRepository {

    override suspend fun getMovies(): Flow<DataState<ResponseMovies?>> =
        flow {
            emit(DataState.Loading)
            runRemoteApiCall(
                success = {
                    emit(DataState.Success(data = data))
                }
            ) {
                api.getMovies(key = "cb03b960")
            }
        }
}