package com.example.mvvm_movie.data

import com.example.mvvm_movie.model.GenreResponse
import com.example.mvvm_movie.model.NowPlayingResponse
import io.reactivex.Observable

class NetworkRepositoryImpl(val remote: RemoteDataSource) : NetworkRepository {
    override fun getGenre(): Observable<GenreResponse> {
        return remote.getGenreList()
    }

    override fun getNowPlaying(): Observable<NowPlayingResponse> {
        return remote.getNowPlaying()
    }

}