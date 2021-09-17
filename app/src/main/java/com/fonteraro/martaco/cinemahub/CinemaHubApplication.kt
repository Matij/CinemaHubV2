package com.fonteraro.martaco.cinemahub;

import com.fonteraro.martaco.cinemahub.di.component.createComponent

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

class CinemaHubApplication: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = createComponent()
}
