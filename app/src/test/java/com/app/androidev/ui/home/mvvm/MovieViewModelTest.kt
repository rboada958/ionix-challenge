package com.app.androidev.ui.home.mvvm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.app.androidev.app.usecase.GetMovieUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class MovieViewModelTest {

    @RelaxedMockK
    private lateinit var movieUseCase: GetMovieUseCase

    private lateinit var movieViewModel: MovieViewModel

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        movieViewModel = MovieViewModel(movieUseCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun getMovies() = runTest {

        coEvery { movieUseCase() }

        movieViewModel.getMovies()
    }
}