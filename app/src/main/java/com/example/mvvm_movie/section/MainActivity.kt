package com.example.mvvm_movie.section

import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import com.example.mvvm_movie.R
import com.example.mvvm_movie.base.BaseActivity
import com.example.mvvm_movie.common.GeneralRecyclerViewAdapter
import com.example.mvvm_movie.model.Result
import com.example.mvvm_movie.section.favoritee.FavoriteFragment
import com.example.mvvm_movie.section.home.HomeFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.subjects.BehaviorSubject
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.viewholder.view.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    private val subject: BehaviorSubject<Fragment> = BehaviorSubject.create()
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                subject.onNext(HomeFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_favorit -> {
                subject.onNext(FavoriteFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun setupLayout() {
        setContentView(R.layout.activity_main)
        subject.onNext(HomeFragment())
    }

    override fun onViewReady() {
        subject.observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                supportFragmentManager.beginTransaction().replace(R.id.fl_content,it).commit()
            }.track()

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }

}
