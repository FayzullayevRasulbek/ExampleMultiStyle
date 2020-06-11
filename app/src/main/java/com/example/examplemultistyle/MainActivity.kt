package com.example.examplemultistyle

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        when (Preferences.themeUI) {
            0 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
//                delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_UNSPECIFIED
            }
            1 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//                delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO
            }
            2 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
//                delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_YES
            }
        }

        btnNext.setOnClickListener {
            startActivity(Intent(this, Main2Activity::class.java))
        }


        btnSystem.setOnClickListener {
            Preferences.themeUI = 0
//            startActivity(intent.apply {
//                flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
//            })
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
//            delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_UNSPECIFIED
        }

        btnLight.setOnClickListener {
            Preferences.themeUI = 1
//            startActivity(intent.apply {
//                flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
//            })
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//            delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO
        }

        btnNight.setOnClickListener {
            Preferences.themeUI = 2
//            startActivity(intent.apply {
//                flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
//            })
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
//            delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_YES
        }
    }

    private fun checkDarkThemeMode(context: Context) {
        val mode = context.resources.configuration.uiMode.and(Configuration.UI_MODE_NIGHT_MASK)
        when (mode) {
            Configuration.UI_MODE_NIGHT_NO -> {
//                themeMode = ThemeOptions.LIGHT
            }
            Configuration.UI_MODE_NIGHT_YES -> {
//                themeMode = ThemeOptions.NIGHT
            }
            Configuration.UI_MODE_NIGHT_UNDEFINED -> {
//                themeMode = ThemeOptions.LIGHT
            }
        }
    }
}