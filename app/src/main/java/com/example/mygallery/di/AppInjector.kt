package com.example.mygallery.di

import com.example.mygallery.App


/**
 * Объект ответственный за создание и хранение [AppComponent]
 */
object AppInjector {

    lateinit var appComponent: AppComponent

    fun initInjector(app: App) {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(app))
            .build()
    }
}