package com.fonteraro.martaco.cinemahub.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fonteraro.martaco.cinemahub.data.MoviesRepository
import com.fonteraro.martaco.cinemahub.di.module.CoroutineDispatchers
import com.fonteraro.martaco.cinemahub.ui.model.Movie
import com.fonteraro.martaco.cinemahub.ui.base.BaseViewModel
import com.fonteraro.martaco.cinemahub.utils.Event
import com.fonteraro.martaco.cinemahub.utils.ResultWrapper
import com.fonteraro.martaco.cinemahub.utils.extensions.toEvent
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val moviesRepository: MoviesRepository,
    dispatchers: CoroutineDispatchers,
): BaseViewModel(dispatchers = dispatchers) {
    private val _movies = MutableLiveData<Event<List<Movie>>>()
    private val _isLoading = MutableLiveData<Event<Boolean>>()

    init {
        retrieveMovies()
    }

    fun onMovieQuery(query: String) {
        updateLoadingState(loading = true)
        if (query.isNotEmpty()) {
            val movies = _movies.value?.peek()
            val searchedText = query.lowercase()
            _movies.value = movies?.filter {
                it.title.lowercase().contains(searchedText) ||
                        it.genre.lowercase().contains(searchedText)
            }?.toEvent()
        } else {
            retrieveMovies()
        }
        updateLoadingState(loading = false)
    }

    private fun retrieveMovies() = uiScope.launch {
        updateLoadingState(loading = true)
        when (val result = moviesRepository.fetchMovies()) {
            is ResultWrapper.Success -> {
                _movies.value = result.value.toEvent()
                updateLoadingState(loading = false)
            }
        }
    }

    private fun updateLoadingState(loading: Boolean) {
        _isLoading.value = loading.toEvent()
    }

    val movies: LiveData<Event<List<Movie>>>
        get() = _movies

    val isLoading: LiveData<Event<Boolean>>
        get() = _isLoading
}
