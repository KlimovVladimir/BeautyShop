package com.example.beautyshop.retrofit

object Common {
    private val BASE_URL = "http://makeup-api.herokuapp.com/api/v1/"
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}