package com.fonteraro.martaco.cinemahub.ui.splash;

import com.fonteraro.martaco.cinemahub.data.DataRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class SplashActivityModule {

    @Provides
    SplashViewModel provideSplashViewModel(DataRepository dataRepository) {
        return new SplashViewModel(dataRepository);
    }
}
