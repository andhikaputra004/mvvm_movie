package com.example.mvvm_movie.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie_table")
    fun getListFav(): LiveData<List<MovieModel>>

    @Insert(onConflict = REPLACE)
    fun insertMovie(movieModel: MovieModel)
}