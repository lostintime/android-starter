package com.example.starter.service

import com.example.starter.api.data.SampleEntity
import io.reactivex.Maybe


interface SampleService {

    /**
     * Returns an Array<Place> resolved by address
     */
    fun getEntities(address: String, target: String? = null): Maybe<Array<SampleEntity>>

}
