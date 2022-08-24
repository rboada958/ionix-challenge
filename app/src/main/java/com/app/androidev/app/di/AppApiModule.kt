package com.app.androidev.app.di

import com.app.androidev.app.networks.api.MovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module(includes = [RetrofitModule::class])
@InstallIn(SingletonComponent::class)
class AppApiModule {

    @Provides
    fun provideMovieApi(retrofit: Retrofit) : MovieApi = retrofit.create(MovieApi::class.java)
}