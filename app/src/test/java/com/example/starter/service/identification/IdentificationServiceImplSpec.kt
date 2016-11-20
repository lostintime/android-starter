package com.example.starter.service.identification

import android.content.SharedPreferences
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import io.kotlintest.specs.FlatSpec
import java.util.regex.Pattern


class IdentificationServiceImplSpec : FlatSpec() {
    init {
        "IdentificationService" should "generate new UUID when not available in shared preferences" {
            val sharedPrefs = mock<SharedPreferences>()
            val editor = mock<SharedPreferences.Editor>()
            val service = IdentificationServiceImpl(sharedPrefs)

            doReturn("")
                    .`when`(sharedPrefs)
                    .getString(IdentificationServiceImpl.INSTALL_UUID_KEY, "")

            doReturn(editor)
                    .`when`(sharedPrefs)
                    .edit()
            val uuid = service.getInstallUuid()
            val isValid = Pattern
                    .matches("[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}", uuid)

            isValid shouldEqual true
        }

        "IdentificationService" should "return saved UUID when available" {
            val sharedPrefs = mock<SharedPreferences>()
            val service = IdentificationServiceImpl(sharedPrefs)

            doReturn("ea63e9cb-1584-4fae-a9e5-19e2083d804d")
                    .`when`(sharedPrefs)
                    .getString(IdentificationServiceImpl.INSTALL_UUID_KEY, "")
            service.getInstallUuid() shouldEqual "ea63e9cb-1584-4fae-a9e5-19e2083d804d"
        }
    }
}
