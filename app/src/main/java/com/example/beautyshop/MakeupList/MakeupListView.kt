package com.example.beautyshop.MakeupList

import com.example.beautyshop.BaseView
import com.example.beautyshop.data.Makeup

interface MakeupListView: BaseView {

    fun bindCharacter(list: List<Makeup>)

    fun openDetailsScreen(makeupId: Long)

    fun openFilterScreen()

    fun openShopBagScreen()
}