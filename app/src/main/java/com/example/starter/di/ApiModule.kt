package com.example.starter.di

import com.example.starter.BuildConfig
import com.example.starter.api.RequestAuthorizationInterceptor
import com.example.starter.api.SampleApi
import com.example.starter.api.data.SampleEntity
import com.example.starter.api.data.json.DateTimeAdapter
import com.example.starter.service.IdentificationService
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import moe.banana.jsonapi2.ResourceAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Provides bindings used to access API resources
 * These module should be used only by other bindings
 */
@Module
class ApiModule {

    @Provides @Singleton @Inject
    fun provideSampleApi(retrofit: Retrofit): SampleApi {
        return retrofit.create(SampleApi::class.java)
    }

    @Provides @Singleton @Inject
    fun provideRetrofit(moshi: Moshi, httpClient: OkHttpClient, idService: IdentificationService): Retrofit {
        val installUuid = idService.getInstallUuid()

        return Retrofit.Builder()
                .baseUrl(BuildConfig.API_BASE_URI)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .client(httpClient
                        .newBuilder()
                        .addInterceptor(RequestAuthorizationInterceptor(installUuid))
                        .build())
                .build();
    }

    @Provides @Singleton
    fun provideMoshiAdapter(): Moshi {
        return Moshi.Builder()
                .add(DateTimeAdapter())
                .add(provideJsonApiAdapter())
                .build()
    }

    private fun provideJsonApiAdapter(): ResourceAdapterFactory {
        return ResourceAdapterFactory.builder()
                .add(SampleEntity::class.java)
                .build()
    }
}
