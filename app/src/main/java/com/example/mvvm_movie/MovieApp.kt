package com.example.mvvm_movie

import com.example.mvvm_movie.di.DaggerAppComponent
import com.example.mvvm_movie.di.DatabaseModule
import com.example.mvvm_movie.di.NetworkModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MovieApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent
            .builder()
            .application(this)
            .databaseModule(DatabaseModule())
            .networkModule(NetworkModule())
            .build()
        appComponent.inject(this)
        return appComponent
    }
}