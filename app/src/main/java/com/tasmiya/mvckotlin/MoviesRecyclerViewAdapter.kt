package com.tasmiya.mvckotlin

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.tasmiya.mvckotlin.databinding.RecyclerMovieItemBinding
import com.tasmiya.mvckotlin.model.Search

/**
 * Created by Tasmiya on 3/13/2020.
 */
//Adapter to show movies
class MoviesRecyclerAdapter(context:Context):RecyclerView.Adapter<MoviesRecyclerAdapter.MoviesViewHolder>(), MoviesEventListener {


      var searches:List<Search>? = null
    internal var context:Context
    init{
        this.context = context
    }

    override fun getItemCount(): Int {
        return if (searches == null) 0 else searches!!.size
    }


    @NonNull
     override fun onCreateViewHolder(@NonNull parent:ViewGroup, viewType:Int):MoviesViewHolder {
        val moviesItemBinding : RecyclerMovieItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.getContext()),
            R.layout.recycler_movie_item, parent, false)
        return MoviesViewHolder(moviesItemBinding)
    }
    override fun onBindViewHolder(@NonNull holder:MoviesViewHolder, position:Int) {
        val currentmovies = searches!!.get(position)
        holder.moviesItemBinding.setMovies(currentmovies)
        holder.moviesItemBinding.setItemClickListner(this)
    }
     fun setMovieList(search:List<Search>) {
        this.searches = search
        notifyDataSetChanged()
    }
    override fun onMovieClicked(s:Search) {
    }
    inner class MoviesViewHolder(@NonNull moviesItemBinding:RecyclerMovieItemBinding):RecyclerView.ViewHolder(moviesItemBinding.getRoot()) {
         val moviesItemBinding:RecyclerMovieItemBinding
        init{
            this.moviesItemBinding = moviesItemBinding
        }
    }
}
