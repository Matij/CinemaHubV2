package com.fonteraro.martaco.cinemahub.ui.details;

import static com.fonteraro.martaco.cinemahub.utils.AppConstants.EXTRA_KEY_MOVIE_ID;

import android.os.Bundle;
import com.fonteraro.martaco.cinemahub.BR;
import com.fonteraro.martaco.cinemahub.R;
import com.fonteraro.martaco.cinemahub.databinding.ActivityDetailsBinding;
import com.fonteraro.martaco.cinemahub.ui.base.BaseActivity;
import javax.inject.Inject;
import androidx.annotation.Nullable;

public class DetailsActivity extends BaseActivity<ActivityDetailsBinding, DetailsViewModel> {

    @Inject
    DetailsViewModel detailsViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getViewDataBinding().setLifecycleOwner(this);
        fetchMovie();
    }

    private void fetchMovie() {
        long movieId = retrieveMovieId();
        if (movieId != -1) getViewModel().getMovieDetails(movieId);
    }

    private Long retrieveMovieId() {
        return getIntent().getLongExtra(EXTRA_KEY_MOVIE_ID, -1);
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
}
