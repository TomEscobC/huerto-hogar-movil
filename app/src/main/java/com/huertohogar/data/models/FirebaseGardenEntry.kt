package com.huertohogar.data.models

import com.huertohogar.data.models.GardenEntry
import java.util.Date

// Firebase-specific model (different from Room model to allow flexibility)
data class FirebaseGardenEntry(
    val id: String = "",
    val userId: String = "", // Added to associate entries with users
    val plantName: String = "",
    val location: String = "",
    val plantingDate: Date = Date(),
    val harvestDate: Date? = null,
    val notes: String = "",
    val photoUrl: String? = null,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val createdAt: Date = Date(),
    val updatedAt: Date = Date()
)