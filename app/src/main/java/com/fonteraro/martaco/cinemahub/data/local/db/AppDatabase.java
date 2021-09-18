package com.fonteraro.martaco.cinemahub.data.local.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.fonteraro.martaco.cinemahub.data.local.db.dao.MovieDao;
import com.fonteraro.martaco.cinemahub.data.local.db.entity.DBMovie;

@Database(entities = {DBMovie.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    // --- SINGLETON ---
    private static volatile AppDatabase INSTANCE;

    // --- DAO ---
    public abstract MovieDao movieDao();
}
