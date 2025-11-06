package com.huertohogar.core.firebase

import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

object FirebaseUtil {
    private var firebaseApp: FirebaseApp? = null
    
    fun initializeFirebase(appContext: android.content.Context) {
        if (firebaseApp == null) {
            firebaseApp = FirebaseApp.initializeApp(appContext)
        }
    }
    
    fun getFirestore(): FirebaseFirestore {
        return Firebase.firestore
    }
    
    fun getAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }
}