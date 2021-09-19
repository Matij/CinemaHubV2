package com.fonteraro.martaco.cinemahub.ui.details

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.fonteraro.martaco.cinemahub.data.MoviesRepository
import com.fonteraro.martaco.cinemahub.di.module.CoroutineDispatchers
import com.fonteraro.martaco.cinemahub.ui.DummyMovieFactory.aMysteryMovie
import com.fonteraro.martaco.cinemahub.ui.model.Movie
import com.fonteraro.martaco.cinemahub.utils.Event
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class DetailsViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    // test object
    private lateinit var viewModel: DetailsViewModel

    // dependencies
    private val moviesRepository: MoviesRepository = mockk(relaxed = true)
    private val dispatcher = Dispatchers.Unconfined
    private val coroutineDispatchers = CoroutineDispatchers(dispatcher, dispatcher, dispatcher)

    // observers
    private val movieLiveDataObserver: Observer<Event<Movie>> = mockk(relaxed = true)

    // state
    private val movie = aMysteryMovie()

    // tests

    @Before
    fun setup() {
        viewModel = DetailsViewModel(
            moviesRepository = moviesRepository,
            dispatchers = coroutineDispatchers
        )
    }

    @Test
    fun `given movies list, when movieId is found, update ui`() {
        viewModel.movie.observeForever(movieLiveDataObserver)

        every { moviesRepository.getMovie(any()) } returns movie

        assertEquals(
            null,
            viewModel.movie.value?.peek()
        )

        verify(exactly = 0) {
            movieLiveDataObserver.onChanged(any())
        }

        viewModel.getMovieDetails(movie.id)

        verify(exactly = 1) {
            movieLiveDataObserver.onChanged(any())
        }

        assertEquals(
            movie,
            viewModel.movie.value?.peek()
        )
    }
}
