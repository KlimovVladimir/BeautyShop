package com.example.beautyshop.MakeupCard

import com.example.beautyshop.BaseView
import com.example.beautyshop.data.Makeup

interface MakeupCardView: BaseView {

    fun bindMakeup(makeup: Makeup)

    fun closeScreen()
}