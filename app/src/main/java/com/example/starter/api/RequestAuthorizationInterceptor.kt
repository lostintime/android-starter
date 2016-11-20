package com.example.starter.api

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response


class RequestAuthorizationInterceptor(private val installUuid: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original: Request = chain.request()

        val requestBuilder: Request.Builder = original.newBuilder()
                .addHeader("X-Install-Uuid", installUuid)

        val request: Request = requestBuilder.build()

        return chain.proceed(request)
    }
}
