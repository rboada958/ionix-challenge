package com.app.androidev.app.usecase

import com.app.androidev.ui.home.mvvm.MovieRepository
import io.mockk.MockKAnnotations
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetMovieUseCaseTest {

    @RelaxedMockK
    private lateinit var movieRepository: MovieRepository

    lateinit var getMovieUseCase: GetMovieUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getMovieUseCase = GetMovieUseCase(movieRepository)
    }

    @Test
    fun `when the api return something value`() = runBlocking {

        getMovieUseCase()

        coVerify(exactly = 1) {
            movieRepository.getMovies()
        }
    }
}