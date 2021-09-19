package com.fonteraro.martaco.cinemahub.ui.main

import androidx.lifecycle.ViewModel
import com.fonteraro.martaco.cinemahub.di.builder.ViewModelFactoryModule
import com.fonteraro.martaco.cinemahub.di.builder.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module(includes = [MainUIModule.MainActivityModule::class])
object MainUIModule {
    @Module
    abstract class MainActivityModule {
        @ContributesAndroidInjector(modules = [
            MainViewModelModule::class
        ])
        abstract fun contributeSubcomponent(): MainActivity
    }

    @Module(includes = [ViewModelFactoryModule::class])
    abstract class MainViewModelModule {
        @Binds
        @IntoMap
        @ViewModelKey(MainViewModel::class)
        abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel
    }
}
