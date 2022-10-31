package com.example.mygallery.ui.screens.search

import com.example.mygallery.base.MviEvent

sealed class SearchScreenEvent : MviEvent {
    data class SearchValueChanged(val value: String) : SearchScreenEvent()
}