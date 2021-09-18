package com.fonteraro.martaco.cinemahub.ui.splash

import com.fonteraro.martaco.cinemahub.di.module.CoroutineDispatchers
import com.fonteraro.martaco.cinemahub.ui.base.BaseViewModel
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    dispatchers: CoroutineDispatchers
) : BaseViewModel(dispatchers = dispatchers)
