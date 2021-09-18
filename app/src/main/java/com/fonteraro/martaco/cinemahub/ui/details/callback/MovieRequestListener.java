package com.fonteraro.martaco.cinemahub.ui.details.callback;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.fonteraro.martaco.cinemahub.ui.model.Movie;

public interface MovieRequestListener {
    void onMovieRequestSucceeded(@NonNull LiveData<Movie> movieDetails);
    void onMovieRequestFailed();
}
