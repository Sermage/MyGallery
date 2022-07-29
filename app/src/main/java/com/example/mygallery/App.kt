package com.example.mygallery

import android.app.Application
import com.example.mygallery.di.AppInjector

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        AppInjector.initInjector(this)

    }
}