package com.fonteraro.martaco.cinemahub.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.fonteraro.martaco.cinemahub.BuildConfig;
import com.fonteraro.martaco.cinemahub.data.DataRepository;
import com.fonteraro.martaco.cinemahub.data.local.db.dao.MovieDao;
import com.fonteraro.martaco.cinemahub.data.local.db.AppDatabase;
import com.fonteraro.martaco.cinemahub.data.local.prefs.AppPreferencesHelper;
import com.fonteraro.martaco.cinemahub.data.local.prefs.PreferencesHelper;
import com.fonteraro.martaco.cinemahub.data.remote.ApiInterface;
import com.fonteraro.martaco.cinemahub.di.PreferenceInfo;
import com.fonteraro.martaco.cinemahub.utils.AppConstants;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Module
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    AppDatabase provideDatabase(Application application) {
        return Room.databaseBuilder(application,
                AppDatabase.class, "AppDatabase.db")
                .build();
    }

    @Provides
    @Singleton
    MovieDao provideUserDao(AppDatabase database) { return database.movieDao(); }

    // --- REPOSITORY INJECTION ---

    @Provides
    Executor provideExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    @Provides
    @Singleton
    DataRepository provideUserRepository(ApiInterface apiInterface, MovieDao movieDao,
                                         AppPreferencesHelper appPreferencesHelper, Executor executor) {
        return new DataRepository(apiInterface, movieDao, appPreferencesHelper, executor);
    }

    // --- NETWORK INJECTION ---

    @Provides
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(JacksonConverterFactory.create())
                .baseUrl(BuildConfig.API_SERVER_URL)
                .build();
    }

    @Provides
    @Singleton
    ApiInterface provideApiInterface(Retrofit restAdapter) {
        return restAdapter.create(ApiInterface.class);
    }

    // --- PREFERENCES ---
    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }
}
