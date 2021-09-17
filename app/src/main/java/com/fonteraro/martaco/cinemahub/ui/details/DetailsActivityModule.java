package com.fonteraro.martaco.cinemahub.ui.details;

import com.fonteraro.martaco.cinemahub.data.DataRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class DetailsActivityModule {

    @Provides
    DetailsViewModel provideDetailsViewModel(DataRepository dataRepository) {
        return new DetailsViewModel(dataRepository);
    }
}
