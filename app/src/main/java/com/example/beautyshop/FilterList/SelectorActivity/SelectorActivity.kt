package com.example.beautyshop.FilterList.SelectorActivity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.beautyshop.BeautyShopApplication
import com.example.beautyshop.MakeupCard.MakeupCardActivity
import com.example.beautyshop.MakeupList.MakeupListActivity
import com.example.beautyshop.MakeupList.MakeupListAdapter
import com.example.beautyshop.R
import com.example.beautyshop.data.Filter

class SelectorActivity: AppCompatActivity(), SelectorView {

    var id : Long = 1

    companion object {
        private val EXTRA_ID = "SELECTOR_EXTRA_ID"

        fun start(context: Context, id: Long) {
            val intent = Intent(context, SelectorActivity::class.java).apply {
                putExtra(EXTRA_ID, id)
            }
            context.startActivity(intent)
            (context as Activity).overridePendingTransition(R.anim.diagonaltranslate, R.anim.alpha)
        }
    }

    private val presenter by lazy {
        SelectorPresenter()
    }

    private val adapter = SelectorAdapter(id) {
        presenter.onCharacterClicked(it)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selector)
        presenter.attachView(this)
        id = intent.getLongExtra(EXTRA_ID, 1)

        val selectorList = findViewById<RecyclerView>(R.id.selectorList)
        selectorList.adapter = adapter

    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.diagonaltranslate, R.anim.alpha)
    }

    override fun closeScreen() {
        finish()
    }

    override fun backToFilterScreen(item: String) {
        (application as BeautyShopApplication).filterRepository.set(Filter(id, item))
        finish()
    }
}