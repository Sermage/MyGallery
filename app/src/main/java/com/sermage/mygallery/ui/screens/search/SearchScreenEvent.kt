package com.sermage.mygallery.ui.screens.search

import com.sermage.mygallery.base.MviEvent

sealed class SearchScreenEvent : MviEvent {
    data class SearchValueChanged(val value: String) : SearchScreenEvent()
}