package com.example.starter.service.sample

import com.example.starter.api.SampleApi
import com.example.starter.api.data.SampleEntity
import com.example.starter.service.SampleService
import io.reactivex.Maybe
import javax.inject.Inject


class SampleServiceImpl @Inject constructor(val api: SampleApi) : SampleService {
    override fun getEntities(address: String, target: String?): Maybe<Array<SampleEntity>> {
        // You mau use api adapter here ...
        return Maybe.empty()
    }
}
