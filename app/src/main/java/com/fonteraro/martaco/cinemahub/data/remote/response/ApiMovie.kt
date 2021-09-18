package com.fonteraro.martaco.cinemahub.data.remote.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiMovie(
    val id: Long,
    val title: String,
    val year: String,
    val genre: String,
    val poster: String,
)
