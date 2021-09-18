package com.fonteraro.martaco.cinemahub.ui.model

import com.github.wrdlbrnft.sortedlistadapter.SortedListAdapter

data class Movie(
    @JvmField var id: Long,
    @JvmField var title: String,
    @JvmField var genre: String,
    @JvmField var poster: String,
    @JvmField var year: String,
): SortedListAdapter.ViewModel {
    override fun <T : Any?> isSameModelAs(model: T): Boolean {
        return when (model is Movie) {
            true -> {
                (model as Movie).id == id
            }
            else -> false
        }
    }

    override fun <T : Any?> isContentTheSameAs(model: T): Boolean {
        return when (model is Movie) {
            true -> {
                val movie = (model as Movie)
                movie.id == id && movie.genre == genre && movie.title == title
            }
            else -> false
        }
    }
}
