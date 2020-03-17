package com.tasmiya.mvckotlin.api


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Tasmiya on 3/13/2020.
 */
 class RetrofitClient {
//Service object to return rerofit call
   companion object{
       var retrofit: Retrofit? = null
       private val BASE_URL = "http://www.omdbapi.com/"
    fun getService(): MyEndPointInterface {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return retrofit?.create(MyEndPointInterface::class.java)!!
    }
}

}
