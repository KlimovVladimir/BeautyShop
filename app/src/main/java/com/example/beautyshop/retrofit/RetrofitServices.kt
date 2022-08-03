package com.example.beautyshop.retrofit
import com.example.beautyshop.data.Makeup
import retrofit2.Call
import retrofit2.http.*

interface RetrofitServices {
    @GET()
    fun getMakeupList(@Url url : String): Call<MutableList<Makeup>>
}