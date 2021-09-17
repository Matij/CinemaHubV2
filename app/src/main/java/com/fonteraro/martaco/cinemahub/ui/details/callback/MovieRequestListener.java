package com.fonteraro.martaco.cinemahub.ui.details.callback;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.fonteraro.martaco.cinemahub.data.model.db.MovieDetails;

public interface MovieRequestListener {
    void onMovieRequestSucceeded(@NonNull LiveData<MovieDetails> movieDetails);
    void onMovieRequestFailed();
}
