package com.example.beautyshop.FilterList.SelectorActivity

import com.example.beautyshop.BasePresenter
import com.example.beautyshop.data.Makeup

class SelectorPresenter: BasePresenter<SelectorView>() {

    fun onCharacterClicked(item : String) {
        view?.backToFilterScreen(item)
    }

}