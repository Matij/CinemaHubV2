package com.fonteraro.martaco.cinemahub.ui.details.callback;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.fonteraro.martaco.cinemahub.data.model.db.MovieDetails;

public interface MovieRequestListener {
    void onMovieRequestSucceeded(@NonNull LiveData<MovieDetails> movieDetails);
    void onMovieRequestFailed();
}
