package com.app.androidev.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.androidev.app.model.MovieItem
import com.app.androidev.databinding.MovieLayoutBinding

class MovieAdapter(
    private var items: MutableList<MovieItem?>,
    private val listener: OnMovieClickListener? = null
) : RecyclerView.Adapter<MovieAdapter.MoviesViewHolder>() {

    class MoviesViewHolder(
        private val binding: MovieLayoutBinding,
        private val listener: OnMovieClickListener? = null
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MovieItem) {
            binding.itemHolder = MovieViewHolder(item) {
                listener?.onMovieClicked(it)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder =
        MoviesViewHolder(
            MovieLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            listener
        )

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) =
        holder.bind(items[position]!!)

    override fun getItemCount(): Int =
        items.size

    fun addItems(list: List<MovieItem?>) {
        val positionStart = items.size
        items.addAll(list)
        notifyItemRangeInserted(positionStart, items.size)
    }

    interface OnMovieClickListener {
        fun onMovieClicked(item: MovieItem)
    }

}