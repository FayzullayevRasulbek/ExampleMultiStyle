package com.example.examplemultistyle

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class App : Application() {


    override fun onCreate() {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        Preferences.init(this)
        setDefaults()
        super.onCreate()

    }

    fun setDefaults() {
        when (Preferences.themeUI) {
            0 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
            }
            1 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            2 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        }
    }
}