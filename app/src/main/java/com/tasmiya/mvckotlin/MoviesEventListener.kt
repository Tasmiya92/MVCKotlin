package com.tasmiya.mvckotlin

import com.tasmiya.mvckotlin.model.Search

/**
 * Created by Tasmiya on 3/13/2020.
 */
//To get listener on click of movie cardview item
interface MoviesEventListener {
    fun onMovieClicked(s : Search)
}