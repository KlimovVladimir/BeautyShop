package com.example.beautyshop

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.beautyshop.data.FilterRepo
import com.example.beautyshop.data.MakeupRepo

class BeautyShopApplication : Application() {

    lateinit var makeupRepository: MakeupRepo
    lateinit var filterRepository: FilterRepo

    override fun onCreate() {
        super.onCreate()
        makeupRepository = MakeupRepo()
        filterRepository = FilterRepo()
    }
}