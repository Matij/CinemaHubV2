package com.fonteraro.martaco.cinemahub.di.module

import dagger.Module
import dagger.multibindings.Multibinds
import okhttp3.Interceptor

@Suppress("unused")
@Module
abstract class BindingsModule {
    // The declaration of multi-binding is necessary in case
    // if there is no bindings and set is empty.
    @Multibinds
    @OkHttpInterceptor
    abstract fun bindInterceptorsSet(): Set<Interceptor>

    @Multibinds
    @OkHttpNetworkInterceptor
    abstract fun bindNetworkInterceptorsSet(): Set<Interceptor>
}
