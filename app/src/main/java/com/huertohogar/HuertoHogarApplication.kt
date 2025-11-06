package com.huertohogar

import android.app.Application
import com.huertohogar.core.firebase.FirebaseUtil

class HuertoHogarApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialize Firebase
        FirebaseUtil.initializeFirebase(this)
    }
}