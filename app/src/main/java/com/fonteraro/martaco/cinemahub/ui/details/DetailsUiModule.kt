package com.fonteraro.martaco.cinemahub.ui.details

import androidx.lifecycle.ViewModel
import com.fonteraro.martaco.cinemahub.di.builder.ViewModelFactoryModule
import com.fonteraro.martaco.cinemahub.di.builder.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module(includes = [
    DetailsUiModule.DetailsActivityModule::class
])
object DetailsUiModule {
    @Module
    abstract class DetailsActivityModule {
        @ContributesAndroidInjector(modules = [
            DetailsViewModelModule::class
        ])
        abstract fun contributeSubcomponent(): DetailsActivity
    }

    @Module(includes = [ViewModelFactoryModule::class])
    abstract class DetailsViewModelModule {
        @Binds
        @IntoMap
        @ViewModelKey(DetailsViewModel::class)
        abstract fun bindDetailsViewModel(viewModel: DetailsViewModel): ViewModel
    }
}
