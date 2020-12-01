package com.example.retrofit_lab

import com.example.retrofit_lab.Model.Todos
import retrofit2.Call
import retrofit2.http.*

interface APIService {


    @GET("todos/")
    fun getTasks(): Call<MutableList<Todos>>


    @GET("todos/{id}/")
    fun getTaskById(@Path("id") todoId: Int): Call<Todos>


    @FormUrlEncoded
    @POST("todos")
    fun addTask(
        @Field("title") title: String,
        @Field("completed") completed: Boolean,
        @Field("id") id: Int,
        @Field("userId") userId: Int): Call<Todos>


    @FormUrlEncoded
    @PUT("todos/{id}/")
    fun updateTask(
        @Path("id") taskId: Int,
        @Field("completed") completed: Boolean): Call<Todos>




//    @GET("users/{id}/")
//    fun getUser(@Path("id") userId: Int): Call<Todos>


    //   @DELETE()
    //
    //   @PUT()
}