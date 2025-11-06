package com.huertohogar.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "garden_entries")
data class GardenEntry(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val plantName: String,
    val location: String,
    val plantingDate: LocalDateTime,
    val harvestDate: LocalDateTime? = null,
    val notes: String = "",
    val photoUri: String? = null,
    val latitude: Double? = null,
    val longitude: Double? = null
)