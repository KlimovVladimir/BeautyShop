package com.example.beautyshop.FilterList

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.beautyshop.BeautyShopApplication
import com.example.beautyshop.FilterList.SelectorActivity.BRANDS_ID
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

    private lateinit var brandText: TextView
    private lateinit var applyButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter_list)
        presenter.attachView(this)

        brandText = findViewById(R.id.product_type)
        brandText.setOnClickListener { openSelectorScreen(BRANDS_ID) }

        applyButton = findViewById(R.id.button)
        applyButton.setOnClickListener {
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
            if (it.id == BRANDS_ID) {
                brandText.text = it.item
            }
        }
    }

    override fun openSelectorScreen(Id: Long) {
        SelectorActivity.start(this,Id)
    }
}