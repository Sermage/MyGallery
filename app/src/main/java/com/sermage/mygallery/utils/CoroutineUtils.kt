package com.sermage.mygallery.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private var debounceJob: Job? = null

fun debounce(
    waitMs: Long = 300L,
    scope: CoroutineScope,
    destinationFunction: () -> Unit
) {
    debounceJob?.cancel()
    debounceJob = scope.launch {
        delay(waitMs)
        destinationFunction()
    }
}
