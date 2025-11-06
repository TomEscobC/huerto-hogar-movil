package com.huertohogar.data.repositories

import com.huertohogar.data.models.FirebaseGardenEntry
import kotlinx.coroutines.flow.Flow

interface FirebaseGardenRepository {
    fun observeGardenEntries(userId: String): Flow<List<FirebaseGardenEntry>>
    suspend fun addGardenEntry(entry: FirebaseGardenEntry): String // returns document ID
    suspend fun updateGardenEntry(entry: FirebaseGardenEntry)
    suspend fun deleteGardenEntry(entryId: String)
    suspend fun getGardenEntry(entryId: String): FirebaseGardenEntry?
}