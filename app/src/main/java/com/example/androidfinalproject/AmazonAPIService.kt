package com.example.androidfinalproject

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val QUERY_STRING =
    "players/#2LUORYYG"

private const val BASE_URL = "https://api.clashroyale.com/v1/"

private const val API_KEY = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6ImRhNjljMjI2LWEyODQtNDQxZi1iMGUwLWZiYWUwYzlhZTNmYiIsImlhdCI6MTYyMjc3Njc1NSwic3ViIjoiZGV2ZWxvcGVyL2M2M2Q0NmE5LWJmYzgtYjg0Ny1jZGRkLWExNzVlNDE2YzM4MSIsInNjb3BlcyI6WyJyb3lhbGUiXSwibGltaXRzIjpbeyJ0aWVyIjoiZGV2ZWxvcGVyL3NpbHZlciIsInR5cGUiOiJ0aHJvdHRsaW5nIn0seyJjaWRycyI6WyIyMDYuMjE5LjY3LjEzMCIsIjczLjEwMS4xOTMuMjA1Il0sInR5cGUiOiJjbGllbnQifV19.IlWdDdpHunprLvJx5vXdRxBcIQ_dcWoUsLGZ6i9z8037vxt5wKS8Ez8kPgBkea5pBYO5s5-DJCyeN41ffS7AKg"



/*
private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(BASE_URL).build()
*/

private val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
    ScalarsConverterFactory.create()).build()

interface AmazonAPIService {
    @GET(QUERY_STRING)
    fun getParts(): Call<String>
}

object PartAPI{
    val partApi: AmazonAPIService by lazy {
        retrofit.create(AmazonAPIService::class.java)
    }
}