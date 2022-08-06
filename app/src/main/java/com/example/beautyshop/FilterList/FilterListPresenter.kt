package com.example.beautyshop.FilterList

import android.widget.EditText
import com.example.beautyshop.BasePresenter
import com.example.beautyshop.BeautyShopApplication
import com.example.beautyshop.FilterList.SelectorActivity.*
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
            if (it.id == PRODUCT_TYPE_ID) {
                if(firstAdd) {
                    firstAdd = false
                    url += "?"
                }
                else {
                    url += "&"
                }
                url += "product_type=" + it.item
            } else if (it.id == PRODUCT_CATEGORY_ID) {
                if(firstAdd) {
                    firstAdd = false
                    url += "?"
                }
                else {
                    url += "&"
                }
                url += "product_category=" + it.item
            } else if (it.id == PRODUCT_TAGS_ID) {
                if(firstAdd) {
                    firstAdd = false
                    url += "?"
                }
                else {
                    url += "&"
                }
                url += "product_tags=" + it.item
            } else if (it.id == BRANDS_ID) {
                if(firstAdd) {
                    firstAdd = false
                    url += "?"
                }
                else {
                    url += "&"
                }
                url += "brand=" + it.item
            } else if (it.id == PRICE_GREATER_THAN_ID) {
                if(firstAdd) {
                    firstAdd = false
                    url += "?"
                }
                else {
                    url += "&"
                }
                url += "price_greater_than=" + it.item
            } else if (it.id == PRICE_LESS_THAN_ID) {
                if(firstAdd) {
                    firstAdd = false
                    url += "?"
                }
                else {
                    url += "&"
                }
                url += "price_less_than=" + it.item
            } else if (it.id == RATING_GRATER_THAN_ID) {
                if(firstAdd) {
                    firstAdd = false
                    url += "?"
                }
                else {
                    url += "&"
                }
                url += "rating_greater_than=" + it.item
            }
        }
        return url
    }

}