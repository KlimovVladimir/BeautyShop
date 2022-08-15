package com.example.beautyshop.MakeupList

import com.example.beautyshop.BasePresenter
import com.example.beautyshop.data.Makeup
import com.example.beautyshop.data.MakeupRepo

class MakeupListPresenter(private val repository: MakeupRepo) : BasePresenter<MakeupListView>() {

    fun onScreenResumed() {
        val makeup = repository.getAll()

        view?.bindCharacter(makeup)
    }

    fun onCharacterClicked(makeup: Makeup) {
        view?.openDetailsScreen(makeup.id)
    }

    fun onFilterClicked() {
        view?.openFilterScreen()
    }

    fun onShopBagClicked() {
        view?.openShopBagScreen()
    }

}