package com.example.mvvm_movie.data

import com.example.mvvm_movie.model.GenreResponse
import com.example.mvvm_movie.model.NowPlayingResponse
import io.reactivex.Observable

interface NetworkRepository {

    fun getNowPlaying(): Observable<NowPlayingResponse>

    fun getGenre() : Observable<GenreResponse>
}
