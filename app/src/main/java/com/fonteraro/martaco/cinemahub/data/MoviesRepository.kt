package com.fonteraro.martaco.cinemahub.data

import com.fonteraro.martaco.cinemahub.data.local.db.dao.MovieDao
import com.fonteraro.martaco.cinemahub.data.local.db.entity.DBMovie
import com.fonteraro.martaco.cinemahub.data.local.prefs.PreferencesHelper
import com.fonteraro.martaco.cinemahub.data.remote.ApiInterface
import com.fonteraro.martaco.cinemahub.ui.model.Movie
import com.fonteraro.martaco.cinemahub.utils.AppConstants.TEN_MINUTES
import com.fonteraro.martaco.cinemahub.utils.NetworkHelper
import com.fonteraro.martaco.cinemahub.utils.ResultWrapper
import java.util.Date
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MoviesRepository @Inject constructor(
    private val apiInterface: ApiInterface,
    private val movieDao: MovieDao,
    private val networkHelper: NetworkHelper,
    private val preferencesHelper: PreferencesHelper,
) {
    suspend fun fetchMovies(): ResultWrapper<List<Movie>> {
        return networkHelper.safeApiCall {
            if (shouldRefreshData()) movieDao.getMovies().map { it.toDomainModel() }
            else apiInterface.getMovies().data.map {
                DBMovie(
                    id = it.id,
                    title = it.title,
                    genre = it.genre,
                    poster = it.poster,
                    year = it.year,
                )
            }.also {
                movieDao.insertAll(it)
            }.toDomainModel()
        }
    }

    fun getMovie(id: Long): Movie {
        return movieDao.getMovie(id).toDomainModel()
    }

    fun getMovies(): List<Movie> {
        return movieDao.getMovies().toDomainModel()
    }

    private fun shouldRefreshData() =
        preferencesHelper.lastRefreshTimestamp != 0L &&
                Date().time - preferencesHelper.lastRefreshTimestamp >= TEN_MINUTES
}

fun List<DBMovie>.toDomainModel(): List<Movie> {
    return map { it.toDomainModel() }
}

fun DBMovie.toDomainModel(): Movie {
    return Movie(
        id = id,
        title = title,
        genre = genre,
        poster = poster,
        year = year
    )
}
