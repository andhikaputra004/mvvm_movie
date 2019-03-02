package com.example.mvvm_movie.data

import android.arch.lifecycle.LiveData
import com.example.mvvm_movie.model.GenreResponse
import com.example.mvvm_movie.model.NowPlayingResponse
import io.reactivex.Observable

class NetworkRepositoryImpl(val remote: RemoteDataSource, val database: MovieDataBase) : NetworkRepository {

    override fun insertMovie(model: MovieModel) {
        return database.movieDao().insertMovie(model)
    }

    override fun getMovie(): LiveData<List<MovieModel>> {
        return database.movieDao().getListFav()
    }

    override fun getGenre(): Observable<GenreResponse> {
        return remote.getGenreList()
    }

    override fun getNowPlaying(): Observable<NowPlayingResponse> {
        return remote.getNowPlaying()
    }

}