package com.example.retrofot.model.retrofit

import com.example.retrofot.data.User
import com.example.retrofot.data.UserList
import com.example.retrofot.data.UserResponse
import retrofit2.Call
import retrofit2.http.*

interface RetroServiceInterface {

    @GET("users")
    @Headers("Accept:application/json", "Content-Type:application/json")
    fun getUserList(): Call<UserList>

    @GET("users")
    @Headers("Accept:application/json", "Content-Type:application/json")
    fun searchUsers(@Query("name")searchText :String): Call<UserList>

    @GET("users{user_id}")
    @Headers("Accept:application/json", "Content-Type:application/json")
    fun getUser(@Path("user_id")user_id :String): Call<UserList>

    @POST("users")
    @Headers("Accept:application/json", "Content-Type:application/json"
        , "Authorization: Bearer 77fbc39333f06b9f21c238de9de0d6f5abb10fb13e341b641aec28be87826e3d" )
    fun createUser(@Body params: User): Call<UserResponse>

    @PATCH("users{user_id}")
    @Headers("Accept:application/json", "Content-Type:application/json"
        , "Authorization: Bearer 77fbc39333f06b9f21c238de9de0d6f5abb10fb13e341b641aec28be87826e3d" )
    fun updateUser(@Path("user_id") user_id: String, @Body params: User): Call<UserResponse>


    @PATCH("users{user_id}")
    @Headers("Accept:application/json", "Content-Type:application/json"
        , "Authorization: Bearer 77fbc39333f06b9f21c238de9de0d6f5abb10fb13e341b641aec28be87826e3d" )
    fun deleteUser(@Path("user_id") user_id: String): Call<UserResponse>

}