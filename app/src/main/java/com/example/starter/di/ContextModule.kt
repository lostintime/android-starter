package com.example.starter.di

import android.content.Context
import android.content.SharedPreferences
import com.example.starter.BuildConfig
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton


@Module
class ContextModule(private val context: Context) {

    @Provides @Singleton
    fun provideContext(): Context = context

    @Provides @Singleton @Named(APP_PREFERENCES_NAME)
    fun provideAppPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(APP_PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    companion object {
        const val APP_PREFERENCES_NAME = "${BuildConfig.APPLICATION_ID}.app_preferences"
    }
}
