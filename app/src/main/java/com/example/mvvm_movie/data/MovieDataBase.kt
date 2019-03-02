package com.example.mvvm_movie.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [MovieModel::class],version = 1,exportSchema = false)
abstract class MovieDataBase : RoomDatabase(){

    abstract fun movieDao() : MovieDao
}