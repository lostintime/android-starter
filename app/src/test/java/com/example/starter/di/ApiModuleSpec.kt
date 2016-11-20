package com.example.starter.di

import com.example.starter.api.data.SampleEntity
import com.squareup.moshi.Moshi
import io.kotlintest.specs.FlatSpec
import javax.inject.Inject


class ApiModuleSpec : FlatSpec() {

    val appComponent = DaggerApiComponent.builder()
            .apiModule(ApiModule())
            .build()

    @Inject
    lateinit var moshi: Moshi

    init {
        appComponent.inject(this)

        val json = """{"data": []}"""

        "Empty array" should "be parsed to empty Array<SampleEntity>" {
            val items: Array<SampleEntity> = moshi.adapter(Array<SampleEntity>::class.java).fromJson(json)
            items.size shouldEqual 0
        }
    }
}
