package com.fonteraro.martaco.cinemahub.ui.main.callback;

import android.support.annotation.NonNull;
import android.view.View;

public class MovieClickListener implements View.OnClickListener {

    @NonNull
    private IMovieClickListener listener;
    @NonNull
    private String movieId;

    public MovieClickListener(@NonNull IMovieClickListener listener, @NonNull String movieId) {
        this.listener = listener;
        this.movieId = movieId;
    }

    @Override
    public void onClick(View view) {
        listener.onMovieClicked(movieId);
    }
}
