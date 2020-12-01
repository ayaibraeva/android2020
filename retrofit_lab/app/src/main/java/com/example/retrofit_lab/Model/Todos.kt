package com.example.retrofit_lab.Model


import com.google.gson.annotations.SerializedName

data class Todos(
    @SerializedName("completed")
    val completed: Boolean,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int
)