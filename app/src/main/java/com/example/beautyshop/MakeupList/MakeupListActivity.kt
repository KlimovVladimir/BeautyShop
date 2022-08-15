package com.example.beautyshop.MakeupList

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.beautyshop.BeautyShopApplication
import com.example.beautyshop.FilterList.FilterListActivity
import com.example.beautyshop.data.Filter
import com.example.beautyshop.MakeupCard.MakeupCardActivity
import com.example.beautyshop.R
import com.example.beautyshop.ShopBagList.ShopBagListActivity
import com.example.beautyshop.data.Makeup
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

    private lateinit var filterButton: Button
    private lateinit var shopBagButton: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var makeupsList: RecyclerView

    fun showLoading() {
        makeupsList.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
    }
    fun hideLoading() {
        makeupsList.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_makeup_list)
        presenter.attachView(this)
        mService = Common.retrofitService

        filterButton = findViewById(R.id.filterButton)
        shopBagButton = findViewById(R.id.shopBagButton)
        progressBar = findViewById(R.id.progressBar)
        makeupsList = findViewById(R.id.makeupList)
        val layoutManager = GridLayoutManager(this, 2)
        makeupsList.setLayoutManager(layoutManager)
        makeupsList.adapter = adapter
        showLoading()
        filterButton.setOnClickListener { presenter.onFilterClicked() }
        shopBagButton.setOnClickListener { presenter.onShopBagClicked() }
        getAllProductList()
    }

    private fun getAllProductList() {
        mService.getMakeupList("products.json?product_type=lip_liner").enqueue(object : Callback<MutableList<Makeup>> {
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

    override fun bindCharacter(list: List<Makeup>) {
        adapter.makeups = list
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