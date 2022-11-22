package com.sermage.mygallery.ui.screens.main

import com.sermage.mygallery.base.MviEvent

sealed class MainScreenEvent : MviEvent {
    object OpenSearchScreen : MainScreenEvent()
    object Reload : MainScreenEvent()
}