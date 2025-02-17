package com.prabh.dogsfeed.data

import com.prabh.dogsfeed.model.GenerateRandomDog
import retrofit2.Response
import retrofit2.http.GET

interface DogsApi {

    @GET("breeds/image/random")
    suspend fun generateRandomDogPic(): Response<GenerateRandomDog>
}