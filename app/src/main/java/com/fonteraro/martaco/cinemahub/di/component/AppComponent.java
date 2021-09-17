package com.fonteraro.martaco.cinemahub.di.component;

import android.app.Application;

import com.fonteraro.martaco.cinemahub.CinemaHubApplication;
import com.fonteraro.martaco.cinemahub.di.builder.ActivityBuilder;
import com.fonteraro.martaco.cinemahub.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {

    void inject(CinemaHubApplication app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
