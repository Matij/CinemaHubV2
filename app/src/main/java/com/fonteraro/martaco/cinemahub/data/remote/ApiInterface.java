package com.fonteraro.martaco.cinemahub.data.remote;

import androidx.annotation.NonNull;

import com.fonteraro.martaco.cinemahub.BuildConfig;
import com.fonteraro.martaco.cinemahub.data.model.db.MovieDetails;
import com.fonteraro.martaco.cinemahub.data.remote.response.MoviesData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET(BuildConfig.MOVIES)
    Call<MoviesData> getMovies();

    @GET(BuildConfig.MOVIES + "/{ID}")
    Call<MovieDetails> getMovie(@Path("ID") @NonNull String id);

}
