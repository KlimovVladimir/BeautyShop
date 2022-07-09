package com.example.beautyshop.MakeupList

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.beautyshop.BeautyShopApplication
import com.example.beautyshop.MakeupCard.MakeupCardActivity
import com.example.beautyshop.R
import com.example.beautyshop.data.Makeup

class MakeupListActivity : AppCompatActivity(), MakeupListView {

    private val presenter by lazy {
        MakeupListPresenter((application as BeautyShopApplication).makeupRepository)
    }

    private val adapter = MakeupListAdapter {
        presenter.onCharacterClicked(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_makeup_list)
        presenter.attachView(this)

        val makeupsList = findViewById<RecyclerView>(R.id.makeupList)
        makeupsList.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        presenter.onScreenResumed()
    }

    override fun bindCharacter(list: List<Makeup>) {
        adapter.makeups = list
    }

    override fun openDetailsScreen(makeupId: Long) {
        MakeupCardActivity.start(this, makeupId)
    }
}