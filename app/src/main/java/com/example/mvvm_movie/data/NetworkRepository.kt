package com.example.mvvm_movie.data

import android.arch.lifecycle.LiveData
import com.example.mvvm_movie.model.GenreResponse
import com.example.mvvm_movie.model.NowPlayingResponse
import io.reactivex.Observable
import io.reactivex.disposables.Disposable

interface NetworkRepository {

    fun getNowPlaying(): Observable<NowPlayingResponse>

    fun getGenre() : Observable<GenreResponse>

    fun insertMovie(model: MovieModel)

    fun getMovie() : LiveData<List<MovieModel>>
}
