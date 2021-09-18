package com.fonteraro.martaco.cinemahub.ui.base

import androidx.lifecycle.ViewModel
import com.fonteraro.martaco.cinemahub.di.module.CoroutineDispatchers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

abstract class BaseViewModel(
    dispatchers : CoroutineDispatchers
) : ViewModel() {
    private val job = SupervisorJob()
    protected val uiScope = CoroutineScope(dispatchers.main + job)
    protected val ioScope = CoroutineScope(dispatchers.io + job)
}
