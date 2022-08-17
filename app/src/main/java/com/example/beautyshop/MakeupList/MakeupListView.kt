package com.example.beautyshop.MakeupList

import com.example.beautyshop.BaseView
import com.example.beautyshop.data.Makeup

interface MakeupListView: BaseView {

    fun bindMakeup(list: List<Makeup>)

    fun searchMakeup(searchText: String)

    fun openDetailsScreen(makeupId: Long)

    fun openFilterScreen()

    fun openShopBagScreen()
}