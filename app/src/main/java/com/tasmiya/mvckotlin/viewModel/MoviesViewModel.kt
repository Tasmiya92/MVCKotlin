package com.tasmiya.mvckotlin.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tasmiya.mvckotlin.api.MyEndPointInterface
import com.tasmiya.mvckotlin.model.Movies
import com.tasmiya.mvckotlin.model.Search
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Tasmiya on 3/16/2020.
 */
class MoviesViewModel: ViewModel() {
    private val BASE_URL = "http://www.omdbapi.com/"
   private var movieList : MutableLiveData<List<Search>> ? = null


    fun  getMovies(): LiveData<List<Search>>?{
        if(movieList == null){
            movieList = MutableLiveData<List<Search>>()
            loadMovies()
        }
        return  movieList

    }

    private fun loadMovies(){
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api: MyEndPointInterface = retrofit.create(MyEndPointInterface::class.java)
        val call : Call<Movies> = api.getMovies()
        call.enqueue(object :Callback<Movies> {
            override fun onFailure(call: Call<Movies>, t: Throwable) {
               Log.d("MoviesViewModel",t.message)
            }

            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                val movieResponse : Movies? = response.body()
                movieList!!.setValue(movieResponse!!.search)
            }


        })

    }

}