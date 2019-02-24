package com.example.mvvm_movie.data

import com.example.mvvm_movie.model.GenreResponse
import com.example.mvvm_movie.model.NowPlayingResponse
import com.example.mvvm_movie.network.NetworkService
import com.example.mvvm_movie.utils.Constant.Common.Companion.API_KEY
import com.example.mvvm_movie.utils.Constant.Common.Companion.LANGUANGE
import io.reactivex.Observable
import javax.inject.Inject

class RemoteDataSource @Inject constructor(val networkService: NetworkService){

    fun getNowPlaying() : Observable<NowPlayingResponse>{
        return  networkService.getNowPlaying(API_KEY, LANGUANGE,1)
    }

    fun getGenreList() : Observable<GenreResponse>{
        return networkService.getGenre(API_KEY, LANGUANGE)
    }
}