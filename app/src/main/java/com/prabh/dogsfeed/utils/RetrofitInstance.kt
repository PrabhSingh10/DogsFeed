package com.prabh.dogsfeed.utils

import com.prabh.dogsfeed.data.DogsApi
import com.prabh.dogsfeed.model.GenerateRandomDog
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "https://dog.ceo/api/"

    val dogsApi by lazy {

        val client = OkHttpClient.Builder()
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        retrofit.create(DogsApi::class.java)
    }
}