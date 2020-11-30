package com.example.networkingsample

import okhttp3.CacheControl
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
   @GET("todos")
   fun getTodos():Call<List<ToDo>>

   @GET("todos/{id}/")
   fun getTodoById(@Path("id") todoId: Int): Call<ToDo>

   @Headers( "CacheControl: max -age= 640000","User-Agent: My-App-Name")
   @GET("todos/")
   fun getTodosByUserId(@Query("userId") userId: Int, @Query("completed") completed: Boolean): Call<List<ToDo>>

   @FormUrlEncoded
  @POST("todos/")
  fun addTodo(@Field("userId") userId: Int, @Field("title") title:String, @Field("completed") completed: Boolean): Call<ToDo>

   @GET()
   fun getTodosWithUrl(@Url url: String):Call<List<ToDo>>
//
//   @DELETE()
//
//   @PUT()
}