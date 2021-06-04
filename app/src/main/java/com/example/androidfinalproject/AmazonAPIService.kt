package com.example.androidfinalproject

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val QUERY_STRING =
    "?url=https://www.amazon.com/dp/B07SXMZLPK/ref=cm_sw_r_tw_dp_94DQDM4JDZDCS6BNRF48"

private const val BASE_URL = "http://api-prd.axesso.de/amz/amazon-lookup-product/"

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