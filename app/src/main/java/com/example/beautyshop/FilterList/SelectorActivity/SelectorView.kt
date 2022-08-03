package com.example.beautyshop.FilterList.SelectorActivity

import com.example.beautyshop.BaseView

interface SelectorView: BaseView {
    fun closeScreen()
    fun backToFilterScreen(item : String)
}