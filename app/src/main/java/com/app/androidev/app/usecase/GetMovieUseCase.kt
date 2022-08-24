package com.app.androidev.app.usecase

import com.app.androidev.ui.home.mvvm.MovieRepository
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(private val repository: MovieRepository) {

    suspend operator fun invoke() =
        repository.getMovies()
}