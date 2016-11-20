package com.example.starter.service.identification

import android.content.SharedPreferences
import com.example.starter.BuildConfig
import com.example.starter.service.IdentificationService
import java.util.*
import javax.inject.Inject


class IdentificationServiceImpl @Inject constructor(sharedPrefs: SharedPreferences) : IdentificationService {

    private val installUuidVal: String by lazy {
        val savedUuid = sharedPrefs.getString(INSTALL_UUID_KEY, "")
        when (savedUuid) {
            "" -> {
                val newUuid = UUID.randomUUID().toString()
                val editor = sharedPrefs.edit()
                editor.putString(INSTALL_UUID_KEY, newUuid)
                editor.commit()

                newUuid
            }
            else -> savedUuid
        }
    }

    override fun getInstallUuid(): String = installUuidVal

    companion object {
        const val INSTALL_UUID_KEY = "${BuildConfig.APPLICATION_ID}.installUuid"
    }
}
