package com.example.starter.api.data

import com.squareup.moshi.JsonDataException
import com.squareup.moshi.Moshi
import io.kotlintest.matchers.start
import io.kotlintest.specs.FlatSpec
import moe.banana.jsonapi2.ResourceAdapterFactory


class SampleEntitySpec : FlatSpec() {
    val jsonApiAdapterFactory: ResourceAdapterFactory = ResourceAdapterFactory.builder()
            .add(SampleEntity::class.java)
            .build()

    val moshi: Moshi = Moshi.Builder().add(jsonApiAdapterFactory).build()

    init {
        "An empty json array" should "be converted to empty Array<SampleEntity>" {
            val json = "{\"data\":[]}"
            val entities: Array<SampleEntity> = moshi.adapter(Array<SampleEntity>::class.java).fromJson(json)
            entities.size shouldBe 0
        }

        "Null or missing data" should "fail to be converted to SampleEntity" {

            val exception = shouldThrow<JsonDataException> {
                val json = "{\"data\": null}";
                moshi.adapter(SampleEntity::class.java).fromJson(json)
            }

            val exception2 = shouldThrow<JsonDataException> {
                val json = "{}"
                moshi.adapter(SampleEntity::class.java).fromJson(json)
            }

            exception.message ?: "" should start with "Invalid JSON API"
            exception2.message ?: "" should start with "Invalid JSON API"
        }

        "SampleEntity.name" should "be required" {
            val json = """
            {
                "data": {
                    "type": "sampleEntities"
                }
            }
            """
            // no exception on creation
            val entity = moshi.adapter(SampleEntity::class.java).fromJson(json)
            val exception = shouldThrow<UninitializedPropertyAccessException> {
                entity.name shouldEqual "Hello"
            }

            exception.message ?: "" shouldEqual "lateinit property name has not be initialized"
        }
    }
}
