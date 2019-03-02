package com.example.mvvm_movie.di

import android.app.Application
import com.example.mvvm_movie.MovieApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, NetworkModule::class, ActivityBuilder::class,
    FragmentBuilder::class,DatabaseModule::class])
interface AppComponent : AndroidInjector<DaggerApplication> {
    fun inject(application :MovieApp)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun networkModule(networkModule: NetworkModule): Builder
        fun databaseModule(databaseModule: DatabaseModule) : Builder
        fun build(): AppComponent
    }
}
