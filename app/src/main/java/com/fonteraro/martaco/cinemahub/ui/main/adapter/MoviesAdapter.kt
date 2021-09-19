package com.fonteraro.martaco.cinemahub.ui.main.adapter

import android.view.View
import com.fonteraro.martaco.cinemahub.BR
import com.fonteraro.martaco.cinemahub.R
import com.fonteraro.martaco.cinemahub.ui.base.adapter.DataBindingAdapter
import com.fonteraro.martaco.cinemahub.ui.base.adapter.DataBindingViewHolder
import com.fonteraro.martaco.cinemahub.ui.model.Movie

class MoviesAdapter(
    val onClick: (movieId: Long) -> Unit
): DataBindingAdapter<Movie>() {
    override fun onBindViewHolder(holder: DataBindingViewHolder<Movie>, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.binding.setVariable(BR.movie, holder.bindingItem)
        val clickListener = View.OnClickListener {
            val id = holder.bindingItem?.id ?: return@OnClickListener
            onClick(id)
        }
        holder.binding.setVariable(BR.listener, clickListener)
        holder.binding.executePendingBindings()
    }

    override fun getItemViewType(position: Int) = R.layout.movie_item
}
