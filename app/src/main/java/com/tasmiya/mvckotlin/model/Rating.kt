package com.tasmiya.mvckotlin.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Tasmiya on 3/13/2020.
 */
class Rating {
    @SerializedName("Source")
    @Expose
    var source: String? = null

    @SerializedName("Value")
    @Expose
    var value: String? = null
}