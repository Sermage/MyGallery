package com.example.mygallery.di

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(
    private val app: Application
) {

    @Singleton
    @Provides
    fun provideApplication() = app
}