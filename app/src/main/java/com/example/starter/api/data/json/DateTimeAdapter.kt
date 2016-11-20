package com.example.starter.api.data.json

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import org.joda.time.DateTime
import org.joda.time.format.ISODateTimeFormat

class DateTimeAdapter {
    val formatter = ISODateTimeFormat.dateTime()

    @ToJson
    fun toJson(time: DateTime): String {
        return formatter.print(time)
    }

    @FromJson
    fun fromJson(str: String): DateTime {
        return formatter.parseDateTime(str)
    }
}
