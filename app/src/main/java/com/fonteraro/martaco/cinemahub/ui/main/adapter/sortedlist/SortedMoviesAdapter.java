package com.fonteraro.martaco.cinemahub.ui.main.adapter.sortedlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.fonteraro.martaco.cinemahub.data.model.db.Movie;
import com.fonteraro.martaco.cinemahub.databinding.MovieItemBinding;
import com.fonteraro.martaco.cinemahub.ui.main.callback.IMovieClickListener;
import com.github.wrdlbrnft.sortedlistadapter.SortedListAdapter;

import java.util.Comparator;

public class SortedMoviesAdapter extends SortedListAdapter<Movie> {

    private IMovieClickListener listener;

    public SortedMoviesAdapter(@NonNull Context context,
                               @NonNull Comparator<Movie> comparator,
                               @NonNull IMovieClickListener listener) {
        super(context, Movie.class, comparator);

        this.listener = listener;
    }

    @NonNull
    @Override
    protected ViewHolder<? extends Movie> onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent, int viewType) {
        final MovieItemBinding binding = MovieItemBinding.inflate(inflater, parent, false);
        return new MovieViewHolder(binding, listener);
    }
}
