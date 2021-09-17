package com.fonteraro.martaco.cinemahub.ui.main;

import com.fonteraro.martaco.cinemahub.data.DataRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    @Provides
    MainViewModel provideMainViewModel(DataRepository dataRepository) {
        return new MainViewModel(dataRepository);
    }
}