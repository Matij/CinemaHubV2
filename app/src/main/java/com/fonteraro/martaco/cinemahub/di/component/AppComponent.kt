package com.fonteraro.martaco.cinemahub.di.component

import android.app.Application
import com.fonteraro.martaco.cinemahub.CinemaHubApplication
import com.fonteraro.martaco.cinemahub.di.builder.ActivityBuilder
import com.fonteraro.martaco.cinemahub.di.module.AppModule

import javax.inject.Singleton

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityBuilder::class])
interface AppComponent : AndroidInjector<CinemaHubApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}

fun CinemaHubApplication.createComponent() = DaggerAppComponent.factory().create(this)
