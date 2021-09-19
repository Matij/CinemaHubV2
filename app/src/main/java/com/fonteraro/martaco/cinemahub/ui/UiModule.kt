package com.fonteraro.martaco.cinemahub.ui

import com.fonteraro.martaco.cinemahub.ui.details.DetailsUiModule
import com.fonteraro.martaco.cinemahub.ui.main.MainUIModule
import com.fonteraro.martaco.cinemahub.ui.splash.SplashUiModule
import dagger.Module

@Module(includes = [
    SplashUiModule::class,
    MainUIModule::class,
    DetailsUiModule::class,
])
object UiModule
