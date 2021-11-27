package com.example.basicmovieapi.ui.main

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.basicmovieapi.R
import com.example.basicmovieapi.server.connection.MovieContentResponse
import kotlinx.coroutines.InternalCoroutinesApi

/**
 * Updates the data shown in the [RecyclerView].
 */

@InternalCoroutinesApi
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<MovieContentResponse>?) {
    val adapter = recyclerView.adapter as ContentGridAdapter
    adapter.submitList(data)

}



@BindingAdapter("get_poster")
fun bindContent(imgView: ImageView, imgUrl: String?){
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri){
            placeholder(R.drawable.loading)
            error(R.drawable.broken)
        }
    }
}

@BindingAdapter("movieApiStatus")
fun bindStatus(statusImageView: ImageView, status: MovieApiStatus?){
    when (status){
        MovieApiStatus.LOADING ->{
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading)
        }
        MovieApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.error)
        }
        MovieApiStatus.DONE ->{
            statusImageView.visibility = View.GONE
        }
    }
}