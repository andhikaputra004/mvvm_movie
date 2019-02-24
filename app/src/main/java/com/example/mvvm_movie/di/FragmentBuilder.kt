package com.example.mvvm_movie.di

import android.annotation.SuppressLint
import com.example.mvvm_movie.section.favoritee.FavoriteFragment
import com.example.mvvm_movie.section.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@SuppressLint("unused")
@Module
abstract class FragmentBuilder {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun provideFragmentHome(): HomeFragment


    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun provideFragmentFavorite(): FavoriteFragment
}