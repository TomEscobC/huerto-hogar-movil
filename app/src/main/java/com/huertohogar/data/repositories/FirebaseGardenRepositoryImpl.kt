package com.huertohogar.data.repositories

import com.google.firebase.firestore.FirebaseFirestore
import com.huertohogar.data.models.FirebaseGardenEntry
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

class FirebaseGardenRepositoryImpl(
    private val firestore: FirebaseFirestore
) : FirebaseGardenRepository {
    
    override fun observeGardenEntries(userId: String): Flow<List<FirebaseGardenEntry>> = callbackFlow {
        val collectionRef = firestore.collection("users").document(userId).collection("gardenEntries")
        
        val listener = collectionRef.addSnapshotListener { snapshot, exception ->
            if (exception != null) {
                close(exception)
                return@addSnapshotListener
            }
            
            val entries = snapshot?.documents?.mapNotNull { document ->
                try {
                    document.toObject(FirebaseGardenEntry::class.java)?.copy(id = document.id)
                } catch (e: Exception) {
                    null
                }
            } ?: emptyList()
            
            trySend(entries)
        }
        
        awaitClose { listener.remove() }
    }
    
    override suspend fun addGardenEntry(entry: FirebaseGardenEntry): String {
        val collectionRef = firestore.collection("users").document(entry.userId).collection("gardenEntries")
        val result = collectionRef.add(entry).await()
        return result.id
    }
    
    override suspend fun updateGardenEntry(entry: FirebaseGardenEntry) {
        val documentRef = firestore
            .collection("users")
            .document(entry.userId)
            .collection("gardenEntries")
            .document(entry.id)
        
        documentRef.set(entry).await()
    }
    
    override suspend fun deleteGardenEntry(entryId: String) {
        // We need userId to construct the correct path, so we might need to pass it differently
        // For now, we'll assume the entryId contains the full path or we retrieve the document first to get userId
        // This would need to be updated with a more specific approach in a real implementation
    }
    
    override suspend fun getGardenEntry(entryId: String): FirebaseGardenEntry? {
        // This would also require knowing the userId
        return null // Implementation would be specific to how the data is structured
    }
}