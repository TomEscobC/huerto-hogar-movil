package com.huertohogar.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plant_types")
data class PlantType(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val description: String = "",
    val optimalSeason: String = "",
    val wateringFrequency: Int = 7 // in days
)