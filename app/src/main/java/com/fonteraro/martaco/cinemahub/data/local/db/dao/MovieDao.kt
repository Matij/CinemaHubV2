package com.fonteraro.martaco.cinemahub.data.local.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.fonteraro.martaco.cinemahub.data.local.db.entity.DBMovie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie: DBMovie)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(movies: List<DBMovie>)

    @Query("SELECT * FROM movies")
    fun queryMovies(): List<DBMovie>

    @Query("SELECT * FROM movies WHERE id=:movieId")
    fun getMovie(movieId: Long): DBMovie

    @Update
    fun updateMovie(movie: DBMovie)

    @Delete
    fun deleteMovie(movie: DBMovie)
}
