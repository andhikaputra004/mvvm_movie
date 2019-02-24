package com.example.mvvm_movie.section

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.mvvm_movie.base.BaseResponse
import com.example.mvvm_movie.base.BaseViewModel
import com.example.mvvm_movie.base.Status
import com.example.mvvm_movie.data.NetworkRepositoryImpl
import com.example.mvvm_movie.di.FragmentScoped
import com.example.mvvm_movie.model.GenreResponse
import com.example.mvvm_movie.model.NowPlayingResponse
import com.example.mvvm_movie.utils.uisubscribe
import javax.inject.Inject

@FragmentScoped
class MainViewModel @Inject constructor(val repo: NetworkRepositoryImpl) : BaseViewModel() {

    private var response = MutableLiveData<BaseResponse<NowPlayingResponse>>()

    var responseGenre = MutableLiveData<BaseResponse<GenreResponse>>()

    fun getNowPlaying() {
        response.value = BaseResponse(Status.LOADING, null, "")
        compositeDisposable.addAll(
            repo.getNowPlaying().uisubscribe({
                response.value = BaseResponse(Status.SUCCESS, it, null)
            }, {
            })
        )

    }

    fun getGenre() {
        responseGenre.value = BaseResponse(Status.LOADING, null, "")
        compositeDisposable.addAll(
            repo.getGenre().uisubscribe({
                responseGenre.value = BaseResponse(Status.SUCCESS, it, "")
            }, {

            })
        )
    }


    fun fetchList() = response
}

@FragmentScoped
class MainViewModelFactory @Inject constructor(val repo: NetworkRepositoryImpl) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repo) as T
    }
}