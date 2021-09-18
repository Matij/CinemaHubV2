package com.fonteraro.martaco.cinemahub.di.module

import javax.inject.Qualifier

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
@MustBeDocumented
annotation class OkHttpInterceptor

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
@MustBeDocumented
annotation class OkHttpNetworkInterceptor
