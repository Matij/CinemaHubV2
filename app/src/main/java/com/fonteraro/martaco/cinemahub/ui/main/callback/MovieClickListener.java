package com.fonteraro.martaco.cinemahub.ui.main.callback;

import android.view.View;

import androidx.annotation.NonNull;

public class MovieClickListener implements View.OnClickListener {

    @NonNull
    private IMovieClickListener listener;
    @NonNull
    private Long movieId;

    public MovieClickListener(@NonNull IMovieClickListener listener, @NonNull Long movieId) {
        this.listener = listener;
        this.movieId = movieId;
    }

    @Override
    public void onClick(View view) {
        listener.onMovieClicked(movieId);
    }
}
