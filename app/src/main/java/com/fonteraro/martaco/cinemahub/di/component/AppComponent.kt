package com.fonteraro.martaco.cinemahub.di.component

import android.app.Application
import com.fonteraro.martaco.cinemahub.CinemaHubApplication
import com.fonteraro.martaco.cinemahub.di.module.AppModule
import com.fonteraro.martaco.cinemahub.di.module.BindingsModule
import com.fonteraro.martaco.cinemahub.di.module.DispatchersModule
import com.fonteraro.martaco.cinemahub.ui.UiModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    UiModule::class,
    BindingsModule::class,
    DispatchersModule::class
])
interface AppComponent : AndroidInjector<CinemaHubApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}

fun CinemaHubApplication.createComponent() = DaggerAppComponent.factory().create(this)
