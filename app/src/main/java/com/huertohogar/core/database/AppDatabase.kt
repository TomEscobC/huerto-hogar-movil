package com.huertohogar.core.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import android.content.Context
import com.huertohogar.core.database.dao.GardenEntryDao
import com.huertohogar.core.database.dao.MaintenanceRecordDao
import com.huertohogar.core.database.dao.PlantTypeDao
import com.huertohogar.data.models.GardenEntry
import com.huertohogar.data.models.MaintenanceRecord
import com.huertohogar.data.models.PlantType
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

@Database(
    entities = [GardenEntry::class, PlantType::class, MaintenanceRecord::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun gardenEntryDao(): GardenEntryDao
    abstract fun plantTypeDao(): PlantTypeDao
    abstract fun maintenanceRecordDao(): MaintenanceRecordDao
    
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "huerto_hogar_database"
                )
                .build()
                INSTANCE = instance
                instance
            }
        }
    }
}