package com.huertohogar.data.repositories

import com.huertohogar.data.models.GardenEntry
import com.huertohogar.data.models.MaintenanceRecord
import com.huertohogar.data.models.PlantType
import kotlinx.coroutines.flow.Flow

interface GardenRepository {
    fun getAllGardenEntries(): Flow<List<GardenEntry>>
    suspend fun getGardenEntryById(id: Long): GardenEntry?
    suspend fun insertGardenEntry(gardenEntry: GardenEntry): Long
    suspend fun updateGardenEntry(gardenEntry: GardenEntry)
    suspend fun deleteGardenEntry(gardenEntry: GardenEntry)
    fun searchGardenEntries(searchQuery: String): Flow<List<GardenEntry>>
    
    fun getAllPlantTypes(): Flow<List<PlantType>>
    suspend fun getPlantTypeById(id: Long): PlantType?
    suspend fun insertPlantType(plantType: PlantType): Long
    fun searchPlantTypes(searchQuery: String): Flow<List<PlantType>>
    
    fun getMaintenanceRecordsForGardenEntry(gardenEntryId: Long): Flow<List<MaintenanceRecord>>
    suspend fun insertMaintenanceRecord(maintenanceRecord: MaintenanceRecord): Long
}