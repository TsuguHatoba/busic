package com.example.busic.network

import com.example.busic.data.PotterBookItem
import com.example.busic.data.PotterBukuItem
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://hp-api.herokuapp.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface BookServiceApi{
    @GET("api/characters/staff")
    suspend fun getBook() : List<PotterBookItem>
}

interface BukuServiceApi{
    @GET("api/characters/students")
    suspend fun getBuku() : List<PotterBukuItem>
}

object BookApi{
    val retrofitBookApi : BookServiceApi by lazy {
        retrofit.create(BookServiceApi::class.java)
    }
}

object BukuApi{
    val retrofitBukuApi : BukuServiceApi by lazy {
        retrofit.create(BukuServiceApi::class.java)
    }
}