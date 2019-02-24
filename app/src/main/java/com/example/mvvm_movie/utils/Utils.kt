package com.example.mvvm_movie.utils

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import io.reactivex.BackpressureStrategy
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers


fun <T> Observable<T>.transform(): Observable<T> {
    return this.observeOn(AndroidSchedulers.mainThread())
        .onErrorResumeNext(Function { Observable.error(it) })
        .subscribeOn(Schedulers.io())
        .unsubscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}

fun <T> Observable<T>.uisubscribe(
    onNext: (T) -> Unit, onError: (Throwable) -> Unit,
    onCompleted: () -> Unit = {}
): Disposable {
    return this.transform().toFlowable(BackpressureStrategy.BUFFER)
        .subscribe({
            onNext(it)
        }, {
            onError(it)
        }, {
            onCompleted.invoke()
        })
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun ImageView.loadImage(url: String) {
    Glide.with(this).load(url).into(this)
}