package com.example.omdbapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.omdbapi.databinding.ListDatamovieBinding
import com.example.omdbapi.modeldata.MovieData

class MovieAdapter(
    private val listMovie:ArrayList<MovieData>
):RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    inner class  MovieViewHolder(itemView:ListDatamovieBinding):RecyclerView.ViewHolder(itemView.root){
        private val binding = itemView
        fun bind(movieData: MovieData){
            with(binding){
                Glide.with(itemView).load(movieData.gambar).into(imgPoster)
                tvTitle.text = movieData.Title
                tvYear.text = movieData.Year
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(ListDatamovieBinding.inflate(LayoutInflater.from(parent.context),
            parent,false
        ))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(listMovie[position])
    }

    override fun getItemCount(): Int = listMovie.size

}