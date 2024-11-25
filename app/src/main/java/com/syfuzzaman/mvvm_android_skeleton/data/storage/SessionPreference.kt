package com.syfuzzaman.mvvm_android_skeleton.data.storage

import android.content.Context
import android.content.SharedPreferences

const val PREF_NAME_MVVM_ARCH = "MVVM_ARCH"
class SessionPreference (private val pref: SharedPreferences, private val context: Context){

    var demoTest: Boolean
        get() = pref.getBoolean(PREF_DEMO_TEST, false)
        set(isActive) {
            pref.edit().putBoolean(PREF_DEMO_TEST, isActive).apply()
        }


    companion object {
        private const val PREF_DEMO_TEST = "pref_demo_test"
    }
}