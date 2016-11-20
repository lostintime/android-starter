package com.example.starter.di

import android.content.SharedPreferences
import com.example.starter.api.SampleApi
import com.example.starter.service.IdentificationService
import com.example.starter.service.SampleService
import com.example.starter.service.identification.IdentificationServiceImpl
import com.example.starter.service.sample.SampleServiceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

/**
 * Provides binding for application services used in activities
 */
@Module
class ServiceModule {
    @Provides @Singleton @Inject
    fun provideIdentificationService(@Named(ContextModule.APP_PREFERENCES_NAME) sharedPrefs: SharedPreferences): IdentificationService {
        return IdentificationServiceImpl(sharedPrefs)
    }

    @Provides @Singleton @Inject
    fun provideSampleService(api: SampleApi): SampleService {
        return SampleServiceImpl(api)
    }
}
