package com.example.mygallery.ui.screens.main

import com.example.mygallery.base.MviEvent

sealed class MainScreenEvent : MviEvent {
    object OpenSearchScreen : MainScreenEvent()
    object Reload : MainScreenEvent()
}