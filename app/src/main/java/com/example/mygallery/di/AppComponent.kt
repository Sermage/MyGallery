package com.example.mygallery.di

import com.example.mygallery.network.NetworkInteractor
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class, NetworkModule::class]
)
interface AppComponent {
    fun networkInteractor(): NetworkInteractor
}