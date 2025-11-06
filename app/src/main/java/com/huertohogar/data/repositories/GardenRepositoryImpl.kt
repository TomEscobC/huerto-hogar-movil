package com.huertohogar.data.repositories

import com.huertohogar.core.database.dao.GardenEntryDao
import com.huertohogar.core.database.dao.MaintenanceRecordDao
import com.huertohogar.core.database.dao.PlantTypeDao
import com.huertohogar.data.models.GardenEntry
import com.huertohogar.data.models.MaintenanceRecord
import com.huertohogar.data.models.PlantType
import kotlinx.coroutines.flow.Flow

class GardenRepositoryImpl(
    private val gardenEntryDao: GardenEntryDao,
    private val plantTypeDao: PlantTypeDao,
    private val maintenanceRecordDao: MaintenanceRecordDao
) : GardenRepository {
    
    override fun getAllGardenEntries(): Flow<List<GardenEntry>> {
        return gardenEntryDao.getAllGardenEntries()
    }
    
    override suspend fun getGardenEntryById(id: Long): GardenEntry? {
        return gardenEntryDao.getGardenEntryById(id)
    }
    
    override suspend fun insertGardenEntry(gardenEntry: GardenEntry): Long {
        return gardenEntryDao.insertGardenEntry(gardenEntry)
    }
    
    override suspend fun updateGardenEntry(gardenEntry: GardenEntry) {
        gardenEntryDao.updateGardenEntry(gardenEntry)
    }
    
    override suspend fun deleteGardenEntry(gardenEntry: GardenEntry) {
        gardenEntryDao.deleteGardenEntry(gardenEntry)
    }
    
    override fun searchGardenEntries(searchQuery: String): Flow<List<GardenEntry>> {
        return gardenEntryDao.searchGardenEntries(searchQuery)
    }
    
    override fun getAllPlantTypes(): Flow<List<PlantType>> {
        return plantTypeDao.getAllPlantTypes()
    }
    
    override suspend fun getPlantTypeById(id: Long): PlantType? {
        return plantTypeDao.getPlantTypeById(id)
    }
    
    override suspend fun insertPlantType(plantType: PlantType): Long {
        return plantTypeDao.insertPlantType(plantType)
    }
    
    override fun searchPlantTypes(searchQuery: String): Flow<List<PlantType>> {
        return plantTypeDao.searchPlantTypes(searchQuery)
    }
    
    override fun getMaintenanceRecordsForGardenEntry(gardenEntryId: Long): Flow<List<MaintenanceRecord>> {
        return maintenanceRecordDao.getMaintenanceRecordsForGardenEntry(gardenEntryId)
    }
    
    override suspend fun insertMaintenanceRecord(maintenanceRecord: MaintenanceRecord): Long {
        return maintenanceRecordDao.insertMaintenanceRecord(maintenanceRecord)
    }
}