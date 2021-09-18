package com.fonteraro.martaco.cinemahub.ui.main.adapter.sortedlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.fonteraro.martaco.cinemahub.ui.model.Movie;
import com.fonteraro.martaco.cinemahub.databinding.MovieItemBinding;
import com.fonteraro.martaco.cinemahub.ui.main.callback.IMovieClickListener;
import com.github.wrdlbrnft.sortedlistadapter.SortedListAdapter;

import java.util.Comparator;

public class SortedMoviesAdapter extends SortedListAdapter<Movie> {

    private IMovieClickListener listener;

    public SortedMoviesAdapter(@NonNull Context context,
                               @NonNull IMovieClickListener listener) {
        super(context, Movie.class, COMPARATOR);

        this.listener = listener;
    }

    @NonNull
    @Override
    protected ViewHolder<? extends Movie> onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent, int viewType) {
        final MovieItemBinding binding = MovieItemBinding.inflate(inflater, parent, false);
        return new MovieViewHolder(binding, listener);
    }

    private static final Comparator<Movie> COMPARATOR = new SortedListAdapter.ComparatorBuilder<Movie>()
            .setOrderForModel(Movie.class, (a, b) -> Integer.signum(a.hashCode() - b.hashCode()))
            .build();


}
