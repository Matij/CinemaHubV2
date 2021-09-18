package com.fonteraro.martaco.cinemahub.di.module

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
object DispatchersModule {
    @Provides
    fun provideIODispatcher() = Dispatchers.IO

    @Provides
    fun provideMainDispatcher() = Dispatchers.Main

    @Provides
    fun provideCoroutineDispatchers() =
        CoroutineDispatchers(Dispatchers.Main, Dispatchers.IO, Dispatchers.Unconfined)
}

data class CoroutineDispatchers(
    val main: CoroutineDispatcher,
    val io: CoroutineDispatcher,
    val unconfined: CoroutineDispatcher
)
