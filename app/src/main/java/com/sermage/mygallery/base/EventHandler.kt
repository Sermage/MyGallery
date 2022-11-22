package com.sermage.mygallery.base

interface EventHandler<T : MviEvent> {

    fun obtainEvent(event: T)
}