package com.example.mvvm_movie.di

import android.app.Application
import android.arch.persistence.room.Room
import com.example.mvvm_movie.data.MovieDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun providesDatabase(application: Application) = Room.databaseBuilder(
        application, MovieDataBase::class.java,
        "movie_db")
        .build()

    @Provides
    @Singleton
    fun providesMovieDao(dataBase: MovieDataBase) = dataBase.movieDao()
}