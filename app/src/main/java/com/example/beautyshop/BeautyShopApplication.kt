package com.example.beautyshop

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.beautyshop.data.FilterRepo
import com.example.beautyshop.data.MakeupRepo
import com.example.beautyshop.data.ShopBagRepo

class BeautyShopApplication : Application() {

    lateinit var makeupRepository: MakeupRepo
    lateinit var filterRepository: FilterRepo
    lateinit var shopBagRepository: ShopBagRepo

    override fun onCreate() {
        super.onCreate()
        makeupRepository = MakeupRepo()
        filterRepository = FilterRepo()
        shopBagRepository = ShopBagRepo()
    }
}