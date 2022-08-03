package com.example.beautyshop.FilterList

import com.example.beautyshop.BaseView
import com.example.beautyshop.data.Filter

interface FilterListView: BaseView {
    fun closeScreen()
    fun openSelectorScreen(Id: Long)
}