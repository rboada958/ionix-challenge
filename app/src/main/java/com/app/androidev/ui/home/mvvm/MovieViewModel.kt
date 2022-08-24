package com.app.androidev.ui.home.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.androidev.app.model.MovieItem
import com.app.androidev.app.usecase.GetMovieUseCase
import com.app.androidev.utils.base.DataState
import com.app.androidev.utils.base.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getMovieUseCase: GetMovieUseCase
) : ViewModel() {

    private val _movieUiState = MutableLiveData<Event<MovieUiState>>()
    val movieUiState: LiveData<Event<MovieUiState>> get() = _movieUiState

    fun getMovies() =
        viewModelScope.launch {
            getMovieUseCase().collect { data ->
                when (data) {
                    is DataState.Loading -> {
                        _movieUiState.value = Event(MovieUiState.ShowLoading)
                    }
                    is DataState.Success -> {
                        _movieUiState.value = Event(
                            MovieUiState.Success(data.data!!.items!!)
                        )
                    }
                    is DataState.Error -> {
                        data.exception.printStackTrace()
                        _movieUiState.value = Event(
                            MovieUiState.Error(data.exception.message.orEmpty())
                        )
                    }
                    is DataState.OtherError -> {
                        _movieUiState.value = Event(MovieUiState.Error(data.error))
                    }
                }
            }
        }

    sealed class MovieUiState {
        object ShowLoading : MovieUiState()
        class Success(val result: List<MovieItem?>?) : MovieUiState()
        class Error(val msg: String) : MovieUiState()
    }
}