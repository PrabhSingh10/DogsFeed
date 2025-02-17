package com.prabh.dogsfeed.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.prabh.dogsfeed.model.GenerateRandomDog
import kotlinx.coroutines.flow.Flow

@Dao
interface DogsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDog(dog: GenerateRandomDog)

    @Query("SELECT * FROM dog_images ORDER BY id DESC LIMIT 20")
    fun fetchDogs(): Flow<List<GenerateRandomDog>>

    @Query("DELETE FROM dog_images WHERE id NOT IN (:newList)")
    fun deleteOldCache(newList: List<Int>)

    @Query("DELETE FROM dog_images")
    fun clearCache()

}