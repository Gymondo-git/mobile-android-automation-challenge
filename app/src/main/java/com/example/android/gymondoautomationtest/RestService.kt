package com.example.android.gymondoautomationtest

import retrofit2.Call
import retrofit2.http.GET

interface RestService {
    @GET("v2/exercise/?limit=30&status=2&language=2")
    fun getExerciseList(): Call<Exercise>
}