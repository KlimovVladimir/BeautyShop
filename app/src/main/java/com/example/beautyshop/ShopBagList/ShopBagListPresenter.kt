package com.example.beautyshop.ShopBagList

import com.example.beautyshop.BasePresenter
import com.example.beautyshop.data.Makeup
import com.example.beautyshop.data.MakeupRepo
import com.example.beautyshop.data.ShopBagRepo

class ShopBagListPresenter(private val repository: ShopBagRepo) : BasePresenter<ShopBagListView>() {

    fun onScreenResumed() {
        val shops = repository.getAll()
        if (shops.isNotEmpty())
            view?.bindCharacter(shops)
        else
            view?.showEmptyBag()
    }

    fun onCharacterClicked(makeup: Makeup) {
        repository.remove(makeup)
        onScreenResumed()
    }

}