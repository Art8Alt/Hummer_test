package com.example.hammer_test.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.hammer_test.R
import com.example.hammer_test.databinding.FragmentHomeBinding
import com.example.hammer_test.pojo.Meal
import com.example.hammer_test.pojo.MealList
import com.example.hammer_test.retrofit.Retrofitinstance
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import javax.security.auth.callback.Callback

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       Retrofitinstance.api.getRandomMeal().enqueue(object : retrofit2.Callback<MealList>{
           override fun onResponse(call: Call<MealList>, response: Response<MealList>) {
               if(response.body() !=null){
                   val randomMeal: Meal = response.body()!!.meals[0]
                   Glide.with(this@HomeFragment)
                       .load(randomMeal.strMealThumb)
                       .into(binding.imgRandomMeal)
               }else{
                   return
               }
           }

           override fun onFailure(call: Call<MealList>, t: Throwable) {
               Log.d("HomeFragment", t.message.toString())
           }
       })


    }


}