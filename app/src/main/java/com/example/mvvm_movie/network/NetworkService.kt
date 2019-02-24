package com.example.mvvm_movie.network

import com.example.mvvm_movie.model.GenreResponse
import com.example.mvvm_movie.model.NowPlayingResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {

    @GET("movie/now_playing")
    fun getNowPlaying(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Observable<NowPlayingResponse>

    @GET("genre/movie/list")
    fun getGenre(
        @Query("api_key") apiKey: String,
        @Query("language") language: String) : Observable<GenreResponse>
}