package com.example.starter.api

import com.example.starter.api.data.SampleEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface SampleApi {
    @GET("entities")
    fun getEntities(@Query("q") query: String): Call<Array<SampleEntity>>
}
