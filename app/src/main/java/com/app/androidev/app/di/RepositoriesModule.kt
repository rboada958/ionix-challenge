package com.app.androidev.app.di

import com.app.androidev.app.networks.api.MovieApi
import com.app.androidev.ui.home.mvvm.MovieRepository
import com.app.androidev.ui.home.mvvm.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoriesModule {

    @Provides
    fun providesMovieRepository(api: MovieApi) : MovieRepository =
        MovieRepositoryImpl(api)
}