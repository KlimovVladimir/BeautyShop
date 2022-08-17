package com.example.beautyshop.ShopBagList

import com.example.beautyshop.BaseView
import com.example.beautyshop.data.Makeup

interface ShopBagListView: BaseView {
    fun closeScreen()
    fun bindMakeup(list: List<Makeup>)
    fun showEmptyBag()
}