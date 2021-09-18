package com.fonteraro.martaco.cinemahub.ui.main;

import com.fonteraro.martaco.cinemahub.data.MoviesRepository;
import com.fonteraro.martaco.cinemahub.di.module.CoroutineDispatchers;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    @Provides
    MainViewModel provideMainViewModel(MoviesRepository moviesRepository, CoroutineDispatchers dispatchers) {
        return new MainViewModel(moviesRepository, dispatchers);
    }
}
