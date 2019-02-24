package com.example.mvvm_movie.base

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.Disposables

abstract class BaseActivity : DaggerAppCompatActivity(){

    private val actCompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupLayout()
        onViewReady()
    }

    protected abstract fun setupLayout()
    protected abstract fun onViewReady()


    fun Disposable.track(){
        actCompositeDisposable.add(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        actCompositeDisposable.dispose()
    }

}