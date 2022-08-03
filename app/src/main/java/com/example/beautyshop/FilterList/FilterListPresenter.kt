package com.example.beautyshop.FilterList

import android.widget.EditText
import com.example.beautyshop.BasePresenter
import com.example.beautyshop.BeautyShopApplication
import com.example.beautyshop.FilterList.SelectorActivity.BRANDS_ID
import com.example.beautyshop.MakeupList.MakeupListActivity
import com.example.beautyshop.R
import com.example.beautyshop.data.Filter
import com.example.beautyshop.data.Makeup
import com.example.beautyshop.retrofit.Common
import com.example.beautyshop.retrofit.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilterListPresenter(): BasePresenter<FilterListView>() {

    fun applyFilters(filters : List<Filter>) : String {
        var url : String = "products.json"
        var firstAdd : Boolean = true
        filters.forEach {
            if (it.id == BRANDS_ID) {
                if(firstAdd) {
                    firstAdd = false
                    url += "?"
                }
                else {
                    url += "&"
                }
                url += "brand=" + it.item
            }
        }
        return url
    }

}