package com.fonteraro.martaco.cinemahub.data.local.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.fonteraro.martaco.cinemahub.data.local.db.dao.MovieDao;
import com.fonteraro.martaco.cinemahub.data.model.db.Movie;

@Database(entities = {Movie.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    // --- SINGLETON ---
    private static volatile AppDatabase INSTANCE;

    // --- DAO ---
    public abstract MovieDao movieDao();
}
