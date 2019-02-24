package com.example.mvvm_movie.section.home

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvvm_movie.R
import com.example.mvvm_movie.base.BaseResponse
import com.example.mvvm_movie.base.Status
import com.example.mvvm_movie.common.GeneralRecyclerViewAdapter
import com.example.mvvm_movie.model.Genre
import com.example.mvvm_movie.model.GenreResponse
import com.example.mvvm_movie.model.NowPlayingResponse
import com.example.mvvm_movie.model.Result
import com.example.mvvm_movie.section.DetailMovieActivity
import com.example.mvvm_movie.section.MainViewModel
import com.example.mvvm_movie.section.MainViewModelFactory
import com.example.mvvm_movie.utils.Constant.Common.Companion.POSTER_PATH_URL
import com.example.mvvm_movie.utils.Constant.String.Companion.POSTER_IMAGE
import com.example.mvvm_movie.utils.gone
import com.example.mvvm_movie.utils.loadImage
import com.example.mvvm_movie.utils.show
import dagger.android.support.DaggerFragment
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.viewholder.view.*
import javax.inject.Inject

class HomeFragment : DaggerFragment() {


    private val list = mutableListOf<Result>()
    private val bundle = Bundle()
    private val listAdapter by lazy {
        GeneralRecyclerViewAdapter(R.layout.viewholder, list, { model, _, view ->
            bundle.putString(POSTER_IMAGE, model.posterPath)
            val option = activity?.let {
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                    it,
                    view.iv_image, "detail"
                )
            }
            startActivity(Intent(activity, DetailMovieActivity::class.java).apply {
                putExtras(bundle)
            }, option?.toBundle())
        }, { model, view ->
            view.tv_title.text = model.title
            view.iv_image.loadImage("$POSTER_PATH_URL${model.posterPath}")
//            subjectGenre.observeOn(AndroidSchedulers.mainThread())
//                .subscribe {
//                    it.all {
//                        when{
//                            it.id == model.g
//                        }
//                    }
//                }
        })
    }

    @Inject
    lateinit var viewModel: MainViewModel

    @Inject
    lateinit var factory: MainViewModelFactory

    private val subjectGenre: PublishSubject<List<Genre>> = PublishSubject.create()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(rv_list) {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        }

        viewModel = ViewModelProviders.of(this, factory)[MainViewModel::class.java]
        viewModel.getGenre()
        viewModel.responseGenre.observe(this, observeGenre())
        viewModel.getNowPlaying()
        viewModel.fetchList().observe(this, observeList())


    }

    private fun observeGenre(): Observer<BaseResponse<GenreResponse>> {
        return Observer {
            when (it?.status) {
                Status.SUCCESS -> {
                    progress.gone()
                    it.response?.genres?.let { it1 -> subjectGenre.onNext(it1) }
                }
                Status.LOADING -> {
                    progress.show()
                }

                else -> {

                }
            }
        }
    }

    private fun observeList(): Observer<BaseResponse<NowPlayingResponse>> {
        return Observer {
            when (it?.status) {
                Status.SUCCESS -> {
                    progress.gone()
                    list.clear()
                    it.response?.results?.let { it1 -> list.addAll(it1) }
                    listAdapter.notifyDataSetChanged()
                }
                Status.LOADING -> {
                    progress.show()
                }
                else -> {

                }
            }
        }
    }
}