package com.fonteraro.martaco.cinemahub.data.local.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

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

