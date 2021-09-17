package com.fonteraro.martaco.cinemahub.ui.base;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.fonteraro.martaco.cinemahub.data.DataRepository;
import com.fonteraro.martaco.cinemahub.data.model.db.Movie;

import java.util.List;

public abstract class BaseViewModel extends ViewModel {

    private LiveData<List<Movie>> movies;

    private DataRepository dataRepository;

    public BaseViewModel(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public void init() {
        if (this.movies != null) {
            return;
        }
        movies = dataRepository.getMovies();
    }

    public LiveData<List<Movie>> geMovies() {
        return this.movies;
    }

    public DataRepository getDataRepository() {
        return dataRepository;
    }
}
