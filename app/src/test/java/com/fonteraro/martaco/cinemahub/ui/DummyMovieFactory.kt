package com.fonteraro.martaco.cinemahub.ui

import com.fonteraro.martaco.cinemahub.ui.model.Movie

object DummyMovieFactory {
    fun aMoviesList() = listOf<Movie>(

    )

    fun aMysteryMovie() = Movie(
        id = 5556,
        genre = "Mystery",
        title = "Blade Runner 2049",
        poster = "https://image.tbdb.org/t/p/w370_and_h556_bestv2/gajva2L0rPYkEWjzgFIBXCAVBE5.jpg",
        year = "2017"
    )

    fun anActionMovie() = Movie(
        id = 9678,
        genre = "Action",
        title = "Atomic Blonde",
        poster = "https://image.tbdb.org/t/p/w1280/kV9R5h0Yct1kR8Hf8sJ1nX0Vz4x.jpg",
        year = "2017"
    )

    fun anFantasyMovie() = Movie(
        id = 8666,
        genre = "Fantasy",
        title = "Power Rangers",
        poster = "https://image.tbdb.org/t/p/w370_and_h556_bestv2/iRAZIEgfB9N0BObV0QI61Nxh92h.jpg",
        year = "2017"
    )
}
