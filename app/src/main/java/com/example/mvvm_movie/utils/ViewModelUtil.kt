package com.example.mvvm_movie.utils

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider


@Suppress("UNCHECKED_CAST")
object ViewModelUtil {
    fun <T : ViewModel> createFor(model: T): ViewModelProvider.Factory {
        return object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(model.javaClass)) {
                    return model as T
                }
                throw IllegalArgumentException("unexpected model class $modelClass")
            }
        }
    }
}