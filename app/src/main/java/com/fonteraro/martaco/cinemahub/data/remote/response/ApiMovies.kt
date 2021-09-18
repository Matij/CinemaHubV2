package com.fonteraro.martaco.cinemahub.data.remote.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiMovies(val data: List<ApiMovie>)
