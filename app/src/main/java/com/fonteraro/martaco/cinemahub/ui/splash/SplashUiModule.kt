package com.fonteraro.martaco.cinemahub.ui.splash

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import com.fonteraro.martaco.cinemahub.di.builder.ViewModelFactoryModule
import com.fonteraro.martaco.cinemahub.di.builder.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module(includes = [
    SplashUiModule.SplashActivityModule::class
])
object SplashUiModule {
    @SuppressLint("CustomSplashScreen")
    @Module
    abstract class SplashActivityModule {
        @ContributesAndroidInjector(modules = [
            SplashViewModelModule::class
        ])
        abstract fun contributeSubcomponent(): SplashActivity
    }

    @Module(includes = [ViewModelFactoryModule::class])
    abstract class SplashViewModelModule {
        @Binds
        @IntoMap
        @ViewModelKey(SplashViewModel::class)
        abstract fun bindSplashViewModel(viewModel: SplashViewModel): ViewModel
    }
}
