package com.prabh.dogsfeed.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.prabh.dogsfeed.model.GenerateRandomDog

@Database(entities = [GenerateRandomDog::class], version = 1, exportSchema = false)
abstract class DogsDatabase: RoomDatabase() {
    abstract fun dogsDao(): DogsDao

    companion object {
        @Volatile
        private var INSTANCE: DogsDatabase? = null
        fun getDatabase(context: Context): DogsDatabase {
            if (INSTANCE == null) {
                synchronized(DogsDatabase::class.java){
                    if (INSTANCE == null){
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            DogsDatabase::class.java,
                            "dogs_database"
                        ).build()
                    }
                }
            }
            return INSTANCE!!
        }
    }
}