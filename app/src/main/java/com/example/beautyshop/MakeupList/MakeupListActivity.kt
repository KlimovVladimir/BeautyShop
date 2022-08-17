package com.example.beautyshop.MakeupList

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.beautyshop.BeautyShopApplication
import com.example.beautyshop.FilterList.FilterListActivity
import com.example.beautyshop.FilterList.SelectorActivity.BRANDS_ID
import com.example.beautyshop.FilterList.SelectorActivity.PRODUCT_CATEGORY_ID
import com.example.beautyshop.FilterList.SelectorActivity.PRODUCT_TAGS_ID
import com.example.beautyshop.FilterList.SelectorActivity.PRODUCT_TYPE_ID
import com.example.beautyshop.data.Filter
import com.example.beautyshop.MakeupCard.MakeupCardActivity
import com.example.beautyshop.R
import com.example.beautyshop.ShopBagList.ShopBagListActivity
import com.example.beautyshop.data.Makeup
import com.example.beautyshop.data.ProductColors
import com.example.beautyshop.retrofit.Common
import com.example.beautyshop.retrofit.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MakeupListActivity : AppCompatActivity(), MakeupListView {

    lateinit var mService: RetrofitServices
    private val presenter by lazy {
        MakeupListPresenter((application as BeautyShopApplication).makeupRepository)
    }

    private val adapter = MakeupListAdapter {
        presenter.onCharacterClicked(it)
    }

    private lateinit var searchEditText: EditText
    private lateinit var searchButton: Button
    private lateinit var filterButton: Button
    private lateinit var shopBagButton: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var makeupsList: RecyclerView

    fun showLoading() {
        searchButton.isEnabled = false
        makeupsList.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
    }
    fun hideLoading() {
        searchButton.isEnabled = true
        makeupsList.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_makeup_list)
        presenter.attachView(this)
        mService = Common.retrofitService

        searchEditText = findViewById(R.id.searchEditText)
        searchButton = findViewById(R.id.searchButton)
        filterButton = findViewById(R.id.filterButton)
        shopBagButton = findViewById(R.id.shopBagButton)
        progressBar = findViewById(R.id.progressBar)
        makeupsList = findViewById(R.id.makeupList)
        val layoutManager = GridLayoutManager(this, 2)
        makeupsList.setLayoutManager(layoutManager)
        makeupsList.adapter = adapter
        showLoading()
        searchButton.setOnClickListener { presenter.onSearchClicked(searchEditText.text.toString()) }
        filterButton.setOnClickListener { presenter.onFilterClicked() }
        filterButton.setOnClickListener { presenter.onFilterClicked() }
        shopBagButton.setOnClickListener { presenter.onShopBagClicked() }
        getAllProductList()
    }

    private fun getAllProductList() {
        mService.getMakeupList("products.json").enqueue(object : Callback<MutableList<Makeup>> {
            override fun onFailure(call: Call<MutableList<Makeup>>, t: Throwable) {
            }

            override fun onResponse(call: Call<MutableList<Makeup>>, response: Response<MutableList<Makeup>>) {
                (application as BeautyShopApplication).makeupRepository.setAll(response.body() as MutableList<Makeup>)
                adapter.notifyDataSetChanged()
                presenter.onScreenResumed()
                hideLoading()
            }
        })
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
        presenter.onScreenResumed()
    }

    override fun bindMakeup(list: List<Makeup>) {
        adapter.makeups = list
    }

    override fun searchMakeup(searchText: String) {
        showLoading()
        mService.getMakeupList("products.json").enqueue(object : Callback<MutableList<Makeup>> {
            override fun onFailure(call: Call<MutableList<Makeup>>, t: Throwable) {
            }

            override fun onResponse(call: Call<MutableList<Makeup>>, response: Response<MutableList<Makeup>>) {
                (application as BeautyShopApplication).makeupRepository.setAll(response.body() as MutableList<Makeup>)
                var searchResult : MutableList<Makeup> = (application as BeautyShopApplication).makeupRepository.getAll() as MutableList<Makeup>
                var shops : MutableList<Makeup> = mutableListOf()

                searchResult.forEach {
                    if (it.brand?.contains(searchText) == true ||
                        it.name?.contains(searchText) == true ||
                        it.description?.contains(searchText) == true ||
                        it.category?.contains(searchText) == true ||
                        it.product_type?.contains(searchText) == true ||
                        it.tag_list?.contains(searchText) == true) {
                        shops.add(it)
                    }
                }
                adapter.notifyDataSetChanged()
                bindMakeup(shops)
                hideLoading()
            }
        })
    }

    override fun openDetailsScreen(makeupId: Long) {
        MakeupCardActivity.start(this, makeupId)
    }

    override fun openFilterScreen() {
        FilterListActivity.start(this)
    }

    override fun openShopBagScreen() {
        ShopBagListActivity.start(this)
    }
}