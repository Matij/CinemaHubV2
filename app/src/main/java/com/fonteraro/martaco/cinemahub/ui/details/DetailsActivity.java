package com.fonteraro.martaco.cinemahub.ui.details;

import android.arch.lifecycle.LiveData;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.fonteraro.martaco.cinemahub.BR;
import com.fonteraro.martaco.cinemahub.R;
import com.fonteraro.martaco.cinemahub.data.model.db.MovieDetails;
import com.fonteraro.martaco.cinemahub.databinding.ActivityDetailsBinding;
import com.fonteraro.martaco.cinemahub.ui.base.BaseActivity;
import com.fonteraro.martaco.cinemahub.ui.details.callback.MovieRequestListener;

import javax.inject.Inject;

import static com.fonteraro.martaco.cinemahub.utils.AppConstants.EXTRA_KEY_MOVIE_ID;

public class DetailsActivity extends BaseActivity<ActivityDetailsBinding, DetailsViewModel> implements MovieRequestListener {

    @Inject
    DetailsViewModel detailsViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        detailsViewModel.getMovieDetails(getIntent().getStringExtra(EXTRA_KEY_MOVIE_ID), this);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_details;
    }

    @Override
    public DetailsViewModel getViewModel() {
        return detailsViewModel;
    }

    @Override
    public void onMovieRequestSucceeded(@NonNull LiveData<MovieDetails> movieDetails) {
        detailsViewModel.setMovieDetails(movieDetails);
        getViewDataBinding().invalidateAll();
    }

    @Override
    public void onMovieRequestFailed() {
        // show placeholder or error if not data
    }
}
