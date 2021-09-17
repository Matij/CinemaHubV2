package com.fonteraro.martaco.cinemahub.ui.details;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.fonteraro.martaco.cinemahub.data.DataRepository;
import com.fonteraro.martaco.cinemahub.data.model.db.MovieDetails;
import com.fonteraro.martaco.cinemahub.ui.base.BaseViewModel;
import com.fonteraro.martaco.cinemahub.ui.details.callback.MovieRequestListener;

public class DetailsViewModel extends BaseViewModel {

    private LiveData<MovieDetails> movieDetails;

    public DetailsViewModel(DataRepository dataRepository) {
        super(dataRepository);
    }

    public void getMovieDetails(@NonNull String id, @NonNull MovieRequestListener listener) {
        getDataRepository().getMovie(id, listener);
    }

    public void setMovieDetails(LiveData<MovieDetails> movieDetails) {
        this.movieDetails = movieDetails;

    }

    public MovieDetails getMovieDetails() {
        if (movieDetails != null) {
            return movieDetails.getValue();
        }

        return null;
    }
}
