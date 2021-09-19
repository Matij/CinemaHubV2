package com.fonteraro.martaco.cinemahub.ui.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.fonteraro.martaco.cinemahub.data.MoviesRepository
import com.fonteraro.martaco.cinemahub.di.module.CoroutineDispatchers
import com.fonteraro.martaco.cinemahub.ui.main.DummyMovieFactory.aMysteryMovie
import com.fonteraro.martaco.cinemahub.ui.main.DummyMovieFactory.anActionMovie
import com.fonteraro.martaco.cinemahub.ui.main.DummyMovieFactory.anFantasyMovie
import com.fonteraro.martaco.cinemahub.utils.Event
import com.fonteraro.martaco.cinemahub.utils.ResultWrapper
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class MainViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    // test object
    private lateinit var viewModel: MainViewModel

    // dependencies
    private val moviesRepository: MoviesRepository = mockk(relaxed = true)
    private val dispatcher = Dispatchers.Unconfined
    private val coroutineDispatchers = CoroutineDispatchers(dispatcher, dispatcher, dispatcher)

    // observers
    private val loadingStateLiveDataObserver: Observer<Event<Boolean>> = mockk(relaxed = true)

    // data
    private val movies = listOf(aMysteryMovie(), anActionMovie(), anFantasyMovie())

    // tests

    @Test
    fun `given movies request fails, return empty movies list`() {
        coEvery { moviesRepository.fetchMovies() } returns ResultWrapper.NetworkError("You are offline!")

        initViewModelAndFetchData()

        verify(exactly = 1) {
            loadingStateLiveDataObserver.onChanged(any())
        }

        assertEquals(
            emptyList(),
            viewModel.movies.value?.peek()
        )
    }

    @Test
    fun `given movies is successfully fetched and non-empty query input, when match found return filtered movies`() {
        coEvery { moviesRepository.fetchMovies() } returns ResultWrapper.Success(movies)
        val nonEmptyQuery = "Action"

        initViewModelAndFetchData()

        viewModel.onMovieQuery(nonEmptyQuery)

        verify(exactly = 3) {
            loadingStateLiveDataObserver.onChanged(any())
        }

        assertEquals(
            listOf(anActionMovie()),
            viewModel.movies.value?.peek()
        )
    }

    @Test
    fun `given movies is successfully fetched and empty query input, when match found return full movies list`() {
        coEvery { moviesRepository.fetchMovies() } returns ResultWrapper.Success(movies)
        val emptyQuery = ""

        initViewModelAndFetchData()

        viewModel.onMovieQuery(emptyQuery)

        verify(exactly = 5) {
            loadingStateLiveDataObserver.onChanged(any())
        }

        assertEquals(
            movies,
            viewModel.movies.value?.peek()
        )
    }

    private fun initViewModelAndFetchData() {
        viewModel = MainViewModel(
            moviesRepository = moviesRepository,
            dispatchers = coroutineDispatchers
        ).also {
            it.isLoading.observeForever(loadingStateLiveDataObserver)
        }
    }
}
