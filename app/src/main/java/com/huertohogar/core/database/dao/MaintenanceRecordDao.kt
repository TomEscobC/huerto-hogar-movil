package com.huertohogar.core.database.dao

import androidx.room.*
import com.huertohogar.data.models.MaintenanceRecord
import kotlinx.coroutines.flow.Flow

@Dao
interface MaintenanceRecordDao {
    @Query("SELECT * FROM maintenance_records WHERE gardenEntryId = :gardenEntryId ORDER BY date DESC")
    fun getMaintenanceRecordsForGardenEntry(gardenEntryId: Long): Flow<List<MaintenanceRecord>>
    
    @Query("SELECT * FROM maintenance_records WHERE id = :id")
    suspend fun getMaintenanceRecordById(id: Long): MaintenanceRecord?
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMaintenanceRecord(maintenanceRecord: MaintenanceRecord): Long
    
    @Update
    suspend fun updateMaintenanceRecord(maintenanceRecord: MaintenanceRecord)
    
    @Delete
    suspend fun deleteMaintenanceRecord(maintenanceRecord: MaintenanceRecord)
    
    @Query("DELETE FROM maintenance_records WHERE id = :id")
    suspend fun deleteMaintenanceRecordById(id: Long)
}