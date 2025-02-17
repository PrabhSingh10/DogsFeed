package com.prabh.dogsfeed.data

import com.prabh.dogsfeed.model.GenerateRandomDog
import com.prabh.dogsfeed.utils.RetrofitInstance

class DogsRepository(private val dogsDao: DogsDao) {

    suspend fun fetchRandomDog() = RetrofitInstance.dogsApi.generateRandomDogPic()

    fun addDog(dogData: GenerateRandomDog) {
        dogsDao.insertDog(dogData)
    }

    fun fetchDogs() = dogsDao.fetchDogs()

    fun clearOldCache(newList: List<Int>) {
        dogsDao.deleteOldCache(newList)
    }

    fun clearCache() {
        dogsDao.clearCache()
    }
}