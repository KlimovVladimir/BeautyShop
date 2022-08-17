package com.example.beautyshop.FilterList

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.beautyshop.BeautyShopApplication
import com.example.beautyshop.FilterList.SelectorActivity.*
import com.example.beautyshop.FilterList.SelectorActivity.SelectorActivity
import com.example.beautyshop.R
import com.example.beautyshop.data.Filter
import com.example.beautyshop.data.Makeup
import com.example.beautyshop.retrofit.Common
import com.example.beautyshop.retrofit.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilterListActivity: AppCompatActivity(), FilterListView {

    companion object {
        private val EXTRA_ID = "FILTER_LIST_EXTRA_ID"

        fun start(context: Context) {
            val intent = Intent(context, FilterListActivity::class.java).apply {
                putExtra(EXTRA_ID, 0)
            }
            context.startActivity(intent)
            (context as Activity).overridePendingTransition(R.anim.diagonaltranslate,R.anim.alpha)
        }
    }

    private val presenter by lazy {
        FilterListPresenter()
    }

    private lateinit var productTypeText: TextView
    private lateinit var productCategoryText: TextView
    private lateinit var productTagsText: TextView
    private lateinit var brandText: TextView
    private lateinit var priceGreaterThanText: TextView
    private lateinit var priceLessThanText: TextView
    private lateinit var ratingGreaterThanText: TextView
    private lateinit var applyButton: Button
    private lateinit var resetButton: Button
    private lateinit var progressBar: ProgressBar

    fun hideAllViews() {
        productTypeText.visibility = View.GONE
        productCategoryText.visibility = View.GONE
        productTagsText.visibility = View.GONE
        brandText.visibility = View.GONE
        priceGreaterThanText.visibility = View.GONE
        priceLessThanText.visibility = View.GONE
        ratingGreaterThanText.visibility = View.GONE
        applyButton.visibility = View.GONE
        resetButton.visibility = View.GONE
    }

    fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter_list)
        presenter.attachView(this)

        productTypeText = findViewById(R.id.product_type)
        productCategoryText = findViewById(R.id.product_category)
        productTagsText = findViewById(R.id.product_tags)
        brandText = findViewById(R.id.brand)
        priceGreaterThanText = findViewById(R.id.price_greater_than)
        priceLessThanText = findViewById(R.id.price_less_than)
        ratingGreaterThanText = findViewById(R.id.rating_greater_than)
        applyButton = findViewById(R.id.button_apply)
        resetButton = findViewById(R.id.button_reset)
        progressBar = findViewById(R.id.progressBar)

        productTypeText.setOnClickListener { openSelectorScreen(PRODUCT_TYPE_ID) }
        productCategoryText.setOnClickListener { openSelectorScreen(PRODUCT_CATEGORY_ID) }
        productTagsText.setOnClickListener { openSelectorScreen(PRODUCT_TAGS_ID) }
        brandText.setOnClickListener { openSelectorScreen(BRANDS_ID) }

        applyButton.setOnClickListener {
            hideAllViews()
            showLoading()

            var mService: RetrofitServices = Common.retrofitService

            var url : String = presenter.applyFilters((application as BeautyShopApplication).filterRepository.getAll())
            mService.getMakeupList(url).enqueue(object :
                Callback<MutableList<Makeup>> {
                override fun onFailure(call: Call<MutableList<Makeup>>, t: Throwable) {
                }

                override fun onResponse(call: Call<MutableList<Makeup>>, response: Response<MutableList<Makeup>>) {
                    (application as BeautyShopApplication).makeupRepository.setAll(response.body() as MutableList<Makeup>)
                    closeScreen()
                }
            })
        }
        resetButton.setOnClickListener {
            var filters = mutableListOf( Filter(id = 1, item = ""), Filter(id = 2, item = ""), Filter(id = 3, item = ""), Filter(id = 4, item = ""), Filter(id = 5, item = ""), Filter(id = 6, item = ""), Filter(id = 7, item = ""))
            (application as BeautyShopApplication).filterRepository.setAll(filters)
            productTypeText.text = getString(R.string.product_type)
            productCategoryText.text = getString(R.string.product_category)
            productTagsText.text = getString(R.string.product_tags)
            brandText.text = getString(R.string.brand)
            priceGreaterThanText.text = getString(R.string.price)
            priceLessThanText.text = getString(R.string.price)
            ratingGreaterThanText.text = getString(R.string.rating)
        }

    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.diagonaltranslate,R.anim.alpha)
    }

    override fun closeScreen() {
        finish()
    }

    override fun onResume() {
        super.onResume()
        var filter : List<Filter> = (application as BeautyShopApplication).filterRepository.getAll()
        filter.forEach {
            if (it.id == PRODUCT_TYPE_ID && it.item != "") {
                productTypeText.text = it.item
            } else if (it.id == PRODUCT_CATEGORY_ID && it.item != "") {
                productCategoryText.text = it.item
            } else if (it.id == PRODUCT_TAGS_ID && it.item != "") {
                productTagsText.text = it.item
            } else if (it.id == BRANDS_ID && it.item != "") {
                brandText.text = it.item
            }
        }
    }

    override fun openSelectorScreen(Id: Long) {
        SelectorActivity.start(this,Id)
    }
}