package com.example.mvvm_movie.di

import android.annotation.SuppressLint
import com.example.mvvm_movie.section.detail.DetailMovieActivity
import com.example.mvvm_movie.section.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@SuppressLint("unused")
@Module
abstract class ActivityBuilder{

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun providesMainActivity() : MainActivity

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun providesDetailActivity() : DetailMovieActivity


}