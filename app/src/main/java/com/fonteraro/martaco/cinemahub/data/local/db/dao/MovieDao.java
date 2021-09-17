package com.fonteraro.martaco.cinemahub.data.local.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.fonteraro.martaco.cinemahub.data.model.db.Movie;

import java.util.List;

@Dao
public interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Movie movie);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Movie> movies);

    @Query("SELECT * FROM movies")
    LiveData<List<Movie>> queryMovies();

    @Update
    void updateMovie(Movie movie);

    @Delete
    void deleteMovie(Movie movie);
}

