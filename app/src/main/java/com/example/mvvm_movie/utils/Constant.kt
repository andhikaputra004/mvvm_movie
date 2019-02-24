package com.example.mvvm_movie.utils

class Constant{

    interface Common{
        companion object {
            const val BASE_URL = "https://api.themoviedb.org/3/"
            const val API_KEY = "10360af8a825dce0adf684058393f6af"
            const val POSTER_PATH_URL = "https://image.tmdb.org/t/p/w185"
            const val LANGUANGE = "en-US"
        }
    }

    interface String{
        companion object {
            const val HOME = "HOME"
            const val FAVORITE = "FAVORITE"
            const val POSTER_IMAGE = "poster_image"
        }
    }
}