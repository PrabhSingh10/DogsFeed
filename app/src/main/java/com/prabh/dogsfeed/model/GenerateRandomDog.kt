package com.prabh.dogsfeed.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "dog_images")
data class GenerateRandomDog(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @SerializedName("message")
    var dogImageUrl: String? = null,
    @SerializedName("status")
    var status: String? = null
)