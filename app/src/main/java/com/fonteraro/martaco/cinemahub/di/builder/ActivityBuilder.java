package com.fonteraro.martaco.cinemahub.di.builder;

import com.fonteraro.martaco.cinemahub.ui.details.DetailsActivity;
import com.fonteraro.martaco.cinemahub.ui.details.DetailsActivityModule;
import com.fonteraro.martaco.cinemahub.ui.main.MainActivity;
import com.fonteraro.martaco.cinemahub.ui.main.MainActivityModule;
import com.fonteraro.martaco.cinemahub.ui.splash.SplashActivity;
import com.fonteraro.martaco.cinemahub.ui.splash.SplashActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = SplashActivityModule.class)
    abstract SplashActivity bindSplashActivity();

    @ContributesAndroidInjector(modules = DetailsActivityModule.class)
    abstract DetailsActivity bindDetailsActivity();
}
