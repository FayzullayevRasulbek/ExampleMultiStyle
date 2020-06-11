package com.example.examplemultistyle

import android.content.Context
import android.content.SharedPreferences

object Preferences {

    fun init(context: Context) {
        preferences = context.getSharedPreferences("Evo.local", Context.MODE_PRIVATE)
    }

    fun setPreference(preferences: SharedPreferences) {
        this.preferences = preferences
    }

    lateinit var preferences: SharedPreferences

    var themeUI: Int
        get() = preferences.getInt(::themeUI.name, 0)!!
        set(value) {
            preferences.edit().putInt(::themeUI.name, value).apply()
        }
}