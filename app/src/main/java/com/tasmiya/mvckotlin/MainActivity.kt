package com.tasmiya.mvckotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.annotation.Nullable
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.tasmiya.mvckotlin.databinding.ActivityMainBinding
import com.tasmiya.mvckotlin.model.Search
import com.tasmiya.mvckotlin.viewModel.MoviesViewModel

class MainActivity : AppCompatActivity() {
    var moviesViewModel: MoviesViewModel? = null
    var recyclerAdapter:MoviesRecyclerAdapter? = null
    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val activityMainBinding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val recyclerView = activityMainBinding.rcvMovies
        recyclerView.setLayoutManager(LinearLayoutManager(this))
        recyclerView.setHasFixedSize(true)
        progressBar = activityMainBinding.progressBar
        progressBar.setVisibility(View.VISIBLE)
        moviesViewModel = ViewModelProviders.of(this).get(MoviesViewModel::class.java)
        recyclerAdapter = MoviesRecyclerAdapter(this)
        recyclerView.setAdapter(recyclerAdapter)
        getAllMovies()
    }

    private fun getAllMovies() {
        moviesViewModel!!.getMovies()?.observe(this, object: Observer<List<Search>> {
            override fun onChanged(@Nullable searches:List<Search>) {
                recyclerAdapter!!.setMovieList(searches as ArrayList<Search>)
                progressBar.setVisibility(View.GONE)
            }
        })
    }
}
