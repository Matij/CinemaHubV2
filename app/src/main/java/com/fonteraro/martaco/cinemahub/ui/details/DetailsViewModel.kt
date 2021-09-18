package com.fonteraro.martaco.cinemahub.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fonteraro.martaco.cinemahub.ui.base.BaseViewModel
import com.fonteraro.martaco.cinemahub.data.MoviesRepository
import com.fonteraro.martaco.cinemahub.di.module.CoroutineDispatchers
import com.fonteraro.martaco.cinemahub.ui.model.Movie
import com.fonteraro.martaco.cinemahub.utils.Event
import com.fonteraro.martaco.cinemahub.utils.extensions.toEvent
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailsViewModel @Inject constructor(
    private val moviesRepository: MoviesRepository,
    dispatchers: CoroutineDispatchers
) : BaseViewModel(dispatchers = dispatchers) {

    private var _movie = MutableLiveData<Event<Movie>>()

    fun getMovieDetails(movieId: Long) = ioScope.launch {
        moviesRepository.getMovie(movieId).also {
            uiScope.launch { _movie.value = it.toEvent() }
        }
    }

    val movie: LiveData<Event<Movie>>
    get() = _movie
}
