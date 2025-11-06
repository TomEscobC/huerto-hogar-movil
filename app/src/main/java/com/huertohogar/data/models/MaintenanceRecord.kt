package com.huertohogar.data.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(
    tableName = "maintenance_records",
    foreignKeys = [
        ForeignKey(
            entity = GardenEntry::class,
            parentColumns = ["id"],
            childColumns = ["gardenEntryId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class MaintenanceRecord(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val gardenEntryId: Long,
    val maintenanceType: String, // watering, fertilizing, pruning, etc.
    val date: LocalDateTime,
    val notes: String = "",
    val photoUri: String? = null
)