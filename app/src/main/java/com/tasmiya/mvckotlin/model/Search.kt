package com.tasmiya.mvckotlin.model


import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.tasmiya.mvckotlin.R
import androidx.databinding.BindingAdapter

/**
 * Created by Tasmiya on 3/13/2020.
 */
class Search {
    @SerializedName("Title")
    @Expose
    var title : String ? = null

    @SerializedName("Year")
    @Expose
    var year : String ? = null

    @SerializedName("imdbID")
    @Expose
    var imdbID : String ? = null

    @SerializedName("Type")
    @Expose
    var type : String ? = null

    @SerializedName("Poster")
    @Expose
    var poster : String ? = null

    // important code for loading image here
    companion object {
        @BindingAdapter("poster")
        @JvmStatic
        fun loadImage(imageView: ImageView, imageURL: String?) {
            Glide.with(imageView.context)
                .setDefaultRequestOptions(RequestOptions())
                .load(imageURL)
                .placeholder(R.drawable.ic_image)
                .into(imageView)
        }
    }



}