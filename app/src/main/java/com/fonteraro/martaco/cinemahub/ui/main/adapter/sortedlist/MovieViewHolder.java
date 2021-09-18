package com.fonteraro.martaco.cinemahub.ui.main.adapter.sortedlist;

import androidx.annotation.NonNull;

import com.fonteraro.martaco.cinemahub.ui.model.Movie;
import com.fonteraro.martaco.cinemahub.databinding.MovieItemBinding;
import com.fonteraro.martaco.cinemahub.ui.main.callback.IMovieClickListener;
import com.fonteraro.martaco.cinemahub.ui.main.callback.MovieClickListener;
import com.github.wrdlbrnft.sortedlistadapter.SortedListAdapter;

public class MovieViewHolder extends SortedListAdapter.ViewHolder<Movie> {

    private final MovieItemBinding mBinding;

    private IMovieClickListener listener;

    public MovieViewHolder(MovieItemBinding binding, IMovieClickListener listener) {
        super(binding.getRoot());
        mBinding = binding;
        this.listener = listener;
    }

    @Override
    protected void performBind(@NonNull Movie item) {
        mBinding.setMovie(item);
        mBinding.setListener(new MovieClickListener(listener, item.id));
    }
}
