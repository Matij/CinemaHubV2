package com.fonteraro.martaco.cinemahub.ui.splash;

import com.fonteraro.martaco.cinemahub.di.module.CoroutineDispatchers;

import dagger.Module;
import dagger.Provides;

@Module
public class SplashActivityModule {

    @Provides
    SplashViewModel provideSplashViewModel(CoroutineDispatchers dispatchers) {
        return new SplashViewModel(dispatchers);
    }
}
