package com.example.basicmovieapi.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.basicmovieapi.databinding.GridViewItemBinding
import com.example.basicmovieapi.server.connection.MovieContentResponse


// switching to (import androidx.recyclerview.widget.ListAdapter) will solve the problem if there is an error bellow
class ContentGridAdapter:
    ListAdapter<MovieContentResponse, ContentGridAdapter.MovieContentsResponseViewHolder>(DiffCallback){


        class MovieContentsResponseViewHolder(
            private var binding: GridViewItemBinding
        ): RecyclerView.ViewHolder(binding.root){
            fun bind (movieContentResponse: MovieContentResponse){
                binding.content = movieContentResponse
                binding.executePendingBindings()
            }
        }
    companion object DiffCallback: DiffUtil.ItemCallback<MovieContentResponse>(){
        override fun areItemsTheSame(oldItem: MovieContentResponse, newItem: MovieContentResponse): Boolean {
            return oldItem.Title == newItem.Title

            }

        override fun areContentsTheSame(oldItem: MovieContentResponse, newItem: MovieContentResponse): Boolean {
            return oldItem.get_title == newItem.get_title
            }
        }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieContentsResponseViewHolder {
        return MovieContentsResponseViewHolder(GridViewItemBinding.inflate(
            LayoutInflater.from(parent.context)
        ))
    }

    override fun onBindViewHolder(holder: MovieContentsResponseViewHolder, position: Int) {
        val movieContentResponse = getItem(position)
        holder.bind(movieContentResponse)
    }


}




