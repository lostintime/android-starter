package com.example.starter.di

import com.example.starter.StarterApplication
import com.example.starter.ui.MainActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(ContextModule::class, ServiceModule::class, ApiModule::class, NetworkModule::class))
interface AppComponent {
    fun inject(application: StarterApplication)

    fun inject(activity: MainActivity)
}
