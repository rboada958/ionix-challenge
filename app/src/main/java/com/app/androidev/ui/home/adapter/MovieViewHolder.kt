package com.app.androidev.ui.home.adapter

import com.app.androidev.R
import com.app.androidev.app.model.MovieItem
import com.app.androidev.utils.adapter.ItemViewHolder

class MovieViewHolder(val result: MovieItem, val onClick : ((MovieItem) -> Unit)? = null) : ItemViewHolder {
    override val layoutId: Int = R.layout.movie_layout
    override val viewType: Int = -3
}