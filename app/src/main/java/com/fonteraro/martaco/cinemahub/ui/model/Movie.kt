package com.fonteraro.martaco.cinemahub.ui.model

data class Movie(
    @JvmField var id: Long,
    @JvmField var title: String,
    @JvmField var genre: String,
    @JvmField var poster: String,
    @JvmField var year: String,
)
