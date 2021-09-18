package com.fonteraro.martaco.cinemahub.ui.details;

import com.fonteraro.martaco.cinemahub.data.MoviesRepository;
import com.fonteraro.martaco.cinemahub.di.module.CoroutineDispatchers;

import dagger.Module;
import dagger.Provides;

@Module
public class DetailsActivityModule {

    @Provides
    DetailsViewModel provideDetailsViewModel(
            MoviesRepository moviesRepository,
            CoroutineDispatchers dispatchers
    ) {
        return new DetailsViewModel(moviesRepository, dispatchers);
    }
}
