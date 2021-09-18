package com.fonteraro.martaco.cinemahub.di.module;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.fonteraro.martaco.cinemahub.BuildConfig;
import com.fonteraro.martaco.cinemahub.data.local.db.dao.MovieDao;
import com.fonteraro.martaco.cinemahub.data.local.db.AppDatabase;
import com.fonteraro.martaco.cinemahub.data.local.prefs.AppPreferencesHelper;
import com.fonteraro.martaco.cinemahub.data.local.prefs.PreferencesHelper;
import com.fonteraro.martaco.cinemahub.data.remote.ApiInterface;
import com.fonteraro.martaco.cinemahub.di.OkHttpInterceptor;
import com.fonteraro.martaco.cinemahub.di.OkHttpNetworkInterceptor;
import com.fonteraro.martaco.cinemahub.di.PreferenceInfo;
import com.fonteraro.martaco.cinemahub.utils.AppConstants;
import com.squareup.moshi.Moshi;

import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

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
    @Singleton
    Executor provideExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    // --- NETWORK INJECTION ---

    @Provides
    @IntoSet
    @OkHttpNetworkInterceptor
    Interceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            interceptor.level(HttpLoggingInterceptor.Level.BODY);
        } else {
            interceptor.level(HttpLoggingInterceptor.Level.NONE);
        }
        return interceptor;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(
            @OkHttpInterceptor Set<Interceptor> interceptors,
            @OkHttpNetworkInterceptor Set<Interceptor> networkInterceptors
    ) {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS);
        for (Interceptor interceptor : interceptors) {
            clientBuilder.interceptors().add(interceptor);
        }
        for (Interceptor interceptor : networkInterceptors) {
            clientBuilder.interceptors().add(interceptor);
        }
        return clientBuilder.build();
    }

    @Provides
    @Singleton
    Moshi provideMoshi() {
        return new Moshi.Builder()
                .build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(
            OkHttpClient okHttpClient,
            Moshi moshi
    ) {
        return new Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .baseUrl(BuildConfig.API_SERVER_URL)
                .client(okHttpClient)
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
