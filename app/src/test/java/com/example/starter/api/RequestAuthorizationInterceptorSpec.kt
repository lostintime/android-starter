package com.example.starter.api

import io.kotlintest.specs.FlatSpec
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer


class RequestAuthorizationInterceptorSpec : FlatSpec() {
    val server: MockWebServer = MockWebServer()
    val client: OkHttpClient = OkHttpClient()

    init {
        "RequestAuthorizationInterceptor" should "add X-Install-Uuid header" {
            server.enqueue(MockResponse().setBody("Aloha"))

            val interceptor = RequestAuthorizationInterceptor("7b27875d-e865-4b42-830d-75731b4e9a70")
            val client = client.newBuilder().addInterceptor(interceptor).build()

            val response = client.newCall(Request.Builder().url(server.url("/")).build()).execute()
            val request = response.request()

            request.header("X-Install-Uuid") shouldEqual "7b27875d-e865-4b42-830d-75731b4e9a70"
        }
    }
}
