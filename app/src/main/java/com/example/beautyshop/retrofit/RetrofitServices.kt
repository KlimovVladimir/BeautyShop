package com.example.beautyshop.retrofit
import com.example.beautyshop.data.Makeup
import retrofit2.Call
import retrofit2.http.*

interface RetrofitServices {
    @GET("products.json")
    fun getMakeupList(): Call<MutableList<Makeup>>
}