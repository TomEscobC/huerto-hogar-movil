package com.huertohogar.core.database.dao

import androidx.room.*
import com.huertohogar.data.models.PlantType
import kotlinx.coroutines.flow.Flow

@Dao
interface PlantTypeDao {
    @Query("SELECT * FROM plant_types ORDER BY name ASC")
    fun getAllPlantTypes(): Flow<List<PlantType>>
    
    @Query("SELECT * FROM plant_types WHERE id = :id")
    suspend fun getPlantTypeById(id: Long): PlantType?
    
    @Query("SELECT * FROM plant_types WHERE name LIKE '%' || :searchQuery || '%'")
    fun searchPlantTypes(searchQuery: String): Flow<List<PlantType>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlantType(plantType: PlantType): Long
    
    @Update
    suspend fun updatePlantType(plantType: PlantType)
    
    @Delete
    suspend fun deletePlantType(plantType: PlantType)
}