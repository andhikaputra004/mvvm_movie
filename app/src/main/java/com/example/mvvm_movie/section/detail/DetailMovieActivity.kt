package com.example.mvvm_movie.section.detail

import com.example.mvvm_movie.R
import com.example.mvvm_movie.base.BaseActivity
import com.example.mvvm_movie.utils.Constant.Common.Companion.POSTER_PATH_URL
import com.example.mvvm_movie.utils.Constant.String.Companion.POSTER_IMAGE
import com.example.mvvm_movie.utils.loadImage
import kotlinx.android.synthetic.main.activity_detail_movie.*

class DetailMovieActivity : BaseActivity() {

    override fun setupLayout() {
        setContentView(R.layout.activity_detail_movie)
    }

    override fun onViewReady() {
        val bundle = intent.extras
        iv_image_detail.loadImage("$POSTER_PATH_URL${bundle?.getString(POSTER_IMAGE)}")
    }

}