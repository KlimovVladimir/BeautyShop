package com.example.beautyshop.ShopBagList

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.beautyshop.BeautyShopApplication
import com.example.beautyshop.FilterList.FilterListActivity
import com.example.beautyshop.MakeupCard.MakeupCardActivity
import com.example.beautyshop.MakeupList.MakeupListAdapter
import com.example.beautyshop.R
import com.example.beautyshop.data.Makeup
import com.example.beautyshop.retrofit.Common
import com.example.beautyshop.retrofit.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShopBagListActivity : AppCompatActivity(), ShopBagListView {

    companion object {
        private val EXTRA_ID = "SHOP_BAG_EXTRA_ID"

        fun start(context: Context) {
            val intent = Intent(context, ShopBagListActivity::class.java).apply {
                putExtra(EXTRA_ID, 0)
            }
            context.startActivity(intent)
            (context as Activity).overridePendingTransition(R.anim.diagonaltranslate,R.anim.alpha)
        }
    }

    private val presenter by lazy {
        ShopBagListPresenter((application as BeautyShopApplication).shopBagRepository)
    }

    private val adapter = ShopBagListAdapter {
        presenter.onCharacterClicked(it)
    }

    private lateinit var shopsList: RecyclerView
    private lateinit var textEmpty: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopbag)
        presenter.attachView(this)

        shopsList = findViewById(R.id.shopBagList)
        textEmpty = findViewById(R.id.textEmpty)
        val layoutManager = GridLayoutManager(this, 1)
        shopsList.setLayoutManager(layoutManager)
        shopsList.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
        presenter.onScreenResumed()
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.diagonaltranslate,R.anim.alpha)
    }

    override fun closeScreen() {
        finish()
    }

    override fun bindCharacter(list: List<Makeup>) {
        adapter.shops = list
        shopsList.visibility = View.VISIBLE
        textEmpty.visibility = View.GONE
    }

    override fun showEmptyBag() {
        shopsList.visibility = View.GONE
        textEmpty.visibility = View.VISIBLE
    }

}