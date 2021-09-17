package com.fonteraro.martaco.cinemahub.ui.main;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.fonteraro.martaco.cinemahub.BR;
import com.fonteraro.martaco.cinemahub.R;
import com.fonteraro.martaco.cinemahub.data.model.db.Movie;
import com.fonteraro.martaco.cinemahub.databinding.ActivityMainBinding;
import com.fonteraro.martaco.cinemahub.ui.base.BaseActivity;
import com.fonteraro.martaco.cinemahub.ui.details.DetailsActivity;
import com.fonteraro.martaco.cinemahub.ui.main.adapter.sortedlist.SortedMoviesAdapter;
import com.fonteraro.martaco.cinemahub.ui.main.callback.IMovieClickListener;
import com.github.wrdlbrnft.sortedlistadapter.SortedListAdapter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import static com.fonteraro.martaco.cinemahub.utils.AppConstants.EXTRA_KEY_MOVIE_ID;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel>
        implements SearchView.OnQueryTextListener, SortedListAdapter.Callback, IMovieClickListener {

    @Inject
    MainViewModel mainViewModel;

    private SortedMoviesAdapter moviesAdapter;

    private Animator mAnimator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initialiseContentView();

        mainViewModel.init();

        mainViewModel.geMovies().observe(this, this::updateUI);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainViewModel getViewModel() {
        return mainViewModel;
    }

    private void initialiseContentView() {
        RecyclerView moviesRecyclerView = getViewDataBinding().recyclerView;
        moviesRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        moviesAdapter = new SortedMoviesAdapter(this, COMPARATOR, this);
        moviesAdapter.addCallback(this);
        moviesRecyclerView.setAdapter(moviesAdapter);
    }

    private void updateUI(List<Movie> movies) {
        ObservableArrayList<Movie> movieList = new ObservableArrayList<>();
        movieList.addAll(movies);

        moviesAdapter.edit()
                .replaceAll(movieList)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(this);

        return true;
    }

    // SearchView callbacks

    @Override
    public boolean onQueryTextChange(String query) {
        if (!query.isEmpty()) {
            final List<Movie> filteredModelList = filter(Objects.requireNonNull(getViewModel().geMovies().getValue()), query);
            moviesAdapter.edit()
                    .replaceAll(filteredModelList)
                    .commit();

            return true;
        } else {
            moviesAdapter.edit()
                    .replaceAll(Objects.requireNonNull(getViewModel().geMovies().getValue()))
                    .commit();
        }
        return false;
    }

    private static List<Movie> filter(List<Movie> movies, String query) {
        final String lowerCaseQuery = query.toLowerCase();

        final List<Movie> filteredModelList = new ArrayList<>();
        for (Movie movie : movies) {
            final String genre = movie.getGenre().toLowerCase();
            final String title = movie.getTitle().toLowerCase();
            if (genre.contains(lowerCaseQuery) || title.contains(lowerCaseQuery)) {
                filteredModelList.add(movie);
            }
        }
        return filteredModelList;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    // RecyclerView onEdit animations
    @Override
    public void onEditStarted() {
        ActivityMainBinding mBinding = getViewDataBinding();
        if (mBinding.editProgressBar.getVisibility() != View.VISIBLE) {
            mBinding.editProgressBar.setVisibility(View.VISIBLE);
            mBinding.editProgressBar.setAlpha(0.0f);
        }

        if (mAnimator != null) {
            mAnimator.cancel();
        }

        mAnimator = ObjectAnimator.ofFloat(mBinding.editProgressBar, View.ALPHA, 1.0f);
        mAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        mAnimator.start();

        mBinding.recyclerView.animate().alpha(0.5f);
    }

    @Override
    public void onEditFinished() {
        ActivityMainBinding mBinding = getViewDataBinding();

        mBinding.recyclerView.scrollToPosition(0);
        mBinding.recyclerView.animate().alpha(1.0f);

        if (mAnimator != null) {
            mAnimator.cancel();
        }

        mAnimator = ObjectAnimator.ofFloat(mBinding.editProgressBar, View.ALPHA, 0.0f);
        mAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        mAnimator.addListener(new AnimatorListenerAdapter() {

            private boolean mCanceled = false;

            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
                mCanceled = true;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if (!mCanceled) {
                    mBinding.editProgressBar.setVisibility(View.GONE);
                }
            }
        });
        mAnimator.start();
    }

    private static final Comparator<Movie> COMPARATOR = new SortedListAdapter.ComparatorBuilder<Movie>()
            .setOrderForModel(Movie.class, (a, b) -> Integer.signum(a.hashCode() - b.hashCode()))
            .build();

    @Override
    public void onMovieClicked(@NonNull String id) {
        new Handler().post(() -> {
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra(EXTRA_KEY_MOVIE_ID, id);
            startActivity(intent);
        });
    }
}
