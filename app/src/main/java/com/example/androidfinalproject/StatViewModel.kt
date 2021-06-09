package com.example.androidfinalproject

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StatViewModel : ViewModel() {
    private val _response = MutableLiveData<List<Stat>>()
    val response: LiveData<List<Stat>>
        get() = _response
    fun getParts(){
        val request = StatAPI.statApi.getStats()
        request.enqueue(object: Callback<ClashResponse> {
            override fun onFailure(call: Call<ClashResponse>, t: Throwable) {
                Log.d("RESPONSE", "Failure: " + t.message)
            }

            override fun onResponse(call: Call<ClashResponse>, response: Response<ClashResponse>) {
                Log.d("RESPONSE", "Success!")
                val listOfStatsFetched= mutableListOf<Stat>()

                val usgsResponse: ClashResponse? = response.body()

                    val name = "Name"
                    val value = usgsResponse?.clashName

                    val newStat = Stat(name, value)
                    listOfStatsFetched.add(newStat)

                _response.value = listOfStatsFetched
            }
        })
    }
}