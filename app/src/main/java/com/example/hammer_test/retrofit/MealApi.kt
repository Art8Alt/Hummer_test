package com.example.hammer_test.retrofit

import com.example.hammer_test.pojo.MealList
import retrofit2.Call
import retrofit2.http.GET

interface MealApi {

    @GET("random.php")
    fun getRandomMeal():Call<MealList>
}