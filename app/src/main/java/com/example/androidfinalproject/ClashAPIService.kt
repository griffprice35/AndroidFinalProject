package com.example.androidfinalproject

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header

private const val QUERY_STRING =
    "players/%232LU0RYYG"

private const val BASE_URL = "https://api.clashroyale.com/v1/"

private const val API_KEY = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6Ijg5Mjc0NzlmLTU5YzMtNGZjMy05MzNjLWRiYWNiZGZhNDU1NSIsImlhdCI6MTYyMzE2MDk4OSwic3ViIjoiZGV2ZWxvcGVyL2M2M2Q0NmE5LWJmYzgtYjg0Ny1jZGRkLWExNzVlNDE2YzM4MSIsInNjb3BlcyI6WyJyb3lhbGUiXSwibGltaXRzIjpbeyJ0aWVyIjoiZGV2ZWxvcGVyL3NpbHZlciIsInR5cGUiOiJ0aHJvdHRsaW5nIn0seyJjaWRycyI6WyIyMDYuMTg5LjIwNS4yNTEiLCI1NC44Ni41MC4xMzkiXSwidHlwZSI6ImNsaWVudCJ9XX0.LKyGdRQ6nfWEURDUhLEZaHk_G7cyWM7347EjvG7pUIURuVGeRCVkBah5wpSCrj3yVfKZc8At4Qq_obZDB_McaQ"

/*private val client = OkHttpClient.Builder().addInterceptor(MyInterceptor()).build()*/

private val client = OkHttpClient.Builder().addInterceptor{chain ->
    val newRequest: Request = chain.request().newBuilder()
        .addHeader("Authorization", "Bearer " + API_KEY)
        .build()
    chain.proceed(newRequest)
}.build()

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofit = Retrofit.Builder().client(client).addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(BASE_URL).build()

/*private val retrofit = Retrofit.Builder().client(client).baseUrl(BASE_URL).addConverterFactory(
    ScalarsConverterFactory.create()).build()*/

interface ClashAPIService {
    @GET(QUERY_STRING)
    fun getParts(): Call<ClashResponse>
}

object PartAPI{
    val partApi: ClashAPIService by lazy {
        retrofit.create(ClashAPIService::class.java)
    }
}