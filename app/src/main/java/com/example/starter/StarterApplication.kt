package com.example.starter

import android.app.Application
import com.example.starter.di.AppComponent
import com.example.starter.di.ContextModule
import com.example.starter.di.DaggerAppComponent


class StarterApplication : Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
                .contextModule(ContextModule(this))
                .build()
    }

    fun getAppComponent(): AppComponent = appComponent
}
