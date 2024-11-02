package com.example.parcialtp3langmanpoltibohuier.helpers.retrofit

import com.example.parcialtp3langmanpoltibohuier.dataClasses.LoginDataClass
import com.example.parcialtp3langmanpoltibohuier.dataClasses.LoginRequest
import com.example.parcialtp3langmanpoltibohuier.dataClasses.UserDataClass
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface RetrofitService {

    @GET("users/{userId}")
    suspend fun getUserById(
        @Path("userId") userId: Int
    ): UserDataClass

    @POST("auth/login")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): LoginDataClass
}

object RetrofitServiceFactory {
    fun makeRetrofitService(): RetrofitService {
        return Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RetrofitService::class.java)
    }
}