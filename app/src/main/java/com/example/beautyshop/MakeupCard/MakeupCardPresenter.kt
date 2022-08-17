package com.example.beautyshop.MakeupCard

import com.example.beautyshop.BasePresenter
import com.example.beautyshop.data.Makeup
import com.example.beautyshop.data.MakeupRepo

class MakeupCardPresenter(
    private val makeupRepo: MakeupRepo,
    private val makeupId: Long
) : BasePresenter<MakeupCardView>() {

    override fun onViewAttached() {
        val makeup = makeupRepo.get(makeupId)

        if (makeup != null) {
            view?.bindMakeup(makeup)
        } else {
            view?.closeScreen()
        }
    }

    fun onSaveButtonClicked(makeup: Makeup) {
        makeupRepo.set(makeup)

        view?.closeScreen()
    }
}