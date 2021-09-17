package com.fonteraro.martaco.cinemahub.ui.main.adapter.sortedlist;

import android.support.annotation.NonNull;

import com.fonteraro.martaco.cinemahub.data.model.db.Movie;
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

        itemView.setOnClickListener(new MovieClickListener(listener, String.valueOf(item.id)));
    }
}
