package com.huertohogar.core.database.dao

import androidx.room.*
import com.huertohogar.data.models.GardenEntry
import kotlinx.coroutines.flow.Flow

@Dao
interface GardenEntryDao {
    @Query("SELECT * FROM garden_entries ORDER BY createdAt DESC")
    fun getAllGardenEntries(): Flow<List<GardenEntry>>
    
    @Query("SELECT * FROM garden_entries WHERE id = :id")
    suspend fun getGardenEntryById(id: Long): GardenEntry?
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGardenEntry(gardenEntry: GardenEntry): Long
    
    @Update
    suspend fun updateGardenEntry(gardenEntry: GardenEntry)
    
    @Delete
    suspend fun deleteGardenEntry(gardenEntry: GardenEntry)
    
    @Query("DELETE FROM garden_entries WHERE id = :id")
    suspend fun deleteGardenEntryById(id: Long)
    
    @Query("SELECT * FROM garden_entries WHERE plantName LIKE '%' || :searchQuery || '%'")
    fun searchGardenEntries(searchQuery: String): Flow<List<GardenEntry>>
}