package com.example.hammer_test.retrofit

import com.example.hammer_test.pojo.Meal
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofitinstance {

   val api:MealApi by lazy {
       Retrofit.Builder()
           .baseUrl("https://www.themealdb.com/api/json/v1/1/")
           .addConverterFactory(GsonConverterFactory.create())
           .build()
           .create(MealApi::class.java)
   }

}