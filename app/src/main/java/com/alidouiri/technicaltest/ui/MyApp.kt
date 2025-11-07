package com.alidouiri.technicaltest.ui

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
internal class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}