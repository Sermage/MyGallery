package com.example.mygallery.base

interface EventHandler<T : MviEvent> {

    fun obtainEvent(event: T)
}