package com.example.androidfinalproject

import android.icu.text.MessagePattern
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PartViewModel : ViewModel() {
    fun getParts(){
        val request = PartAPI.partApi.getParts()
        request.enqueue(object: Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.d("RESPONSE", "Failure: " + t.message)
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                Log.d("RESPONSE", response.body().toString())
            }
        })
    }
}