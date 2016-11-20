package com.example.starter.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApiModule::class))
interface ApiComponent {
    fun inject(apiModule: ApiModuleSpec)
}