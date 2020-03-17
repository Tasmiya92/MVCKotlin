package com.tasmiya.mvckotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Tasmiya on 3/13/2020.
 */
//Movies details class
class Movies {
    @SerializedName("Search")
    @Expose
    var search : List<Search> ? = null

    @SerializedName("totalResults")
    @Expose
    var totalResults: String ? = null

    @SerializedName("Response")
    @Expose
    var response : String ? = null

}