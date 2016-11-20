package com.example.starter.api.data

import com.squareup.moshi.Json
import moe.banana.jsonapi2.JsonApi
import moe.banana.jsonapi2.Resource


@JsonApi(type = "sampleEntities")
class SampleEntity() : Resource() {
    @Json(name = "name")
    lateinit var name: String
}
