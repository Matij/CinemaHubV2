package com.fonteraro.martaco.cinemahub.utils.extensions

import com.fonteraro.martaco.cinemahub.utils.Event

fun <T : Any> T.toEvent(): Event<T> {
    return Event(this)
}
