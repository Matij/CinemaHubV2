package com.fonteraro.martaco.cinemahub.data.remote

import androidx.annotation.NonNull

import com.fonteraro.martaco.cinemahub.BuildConfig
import com.fonteraro.martaco.cinemahub.data.remote.response.ApiMovie
import com.fonteraro.martaco.cinemahub.data.remote.response.ApiMovies

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET(BuildConfig.MOVIES)
    suspend fun getMovies(): ApiMovies

    @GET("${BuildConfig.MOVIES}/{ID}")
    suspend fun getMovie(@Path("ID") @NonNull id: String): ApiMovie

}
