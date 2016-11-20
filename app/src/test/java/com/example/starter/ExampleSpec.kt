package com.example.starter

import io.kotlintest.specs.FlatSpec

class ExampleSpec : FlatSpec() {
    init {
        "a simple addition" should "should equal its result" {
            2 + 4 shouldEqual 6
        }
    }
}