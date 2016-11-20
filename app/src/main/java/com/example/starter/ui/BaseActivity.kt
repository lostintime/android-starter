package com.example.starter.ui

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import com.crashlytics.android.Crashlytics
import com.example.starter.BuildConfig
import com.example.starter.StarterApplication
import io.fabric.sdk.android.Fabric


open class BaseActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (BuildConfig.ENABLE_CRASHLYTICS) {
            Fabric.with(this, Crashlytics())
        }

    }

    protected fun getStarterApplication() = application as StarterApplication

    protected fun appComponent() = getStarterApplication().getAppComponent()
}
