package com.example.beautyshop.MakeupCard

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.beautyshop.BeautyShopApplication
import com.example.beautyshop.R
import com.example.beautyshop.data.Makeup

class MakeupCardActivity : AppCompatActivity(), MakeupCardView {

    companion object {

        private val EXTRA_ID = "MAKEUP_CARD_EXTRA_ID"

        fun start(context: Context, id: Long) {
            val intent = Intent(context, MakeupCardActivity::class.java).apply {
                putExtra(EXTRA_ID, id)
            }
            context.startActivity(intent)
            (context as Activity).overridePendingTransition(R.anim.diagonaltranslate,R.anim.alpha)
        }
    }

    private val presenter by lazy {
        MakeupCardPresenter(
            (application as BeautyShopApplication).makeupRepository,
            intent.getLongExtra(EXTRA_ID, 0)
        )
    }

    private lateinit var brandText: TextView
    private lateinit var nameText: TextView
    private lateinit var descriptionText: TextView
    private lateinit var priceText: TextView
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_makeup_card)

        brandText = findViewById(R.id.brandText)
        nameText = findViewById(R.id.nameText)
        descriptionText = findViewById(R.id.descriptionText)
        priceText = findViewById(R.id.priceText)
        saveButton = findViewById(R.id.saveButton)

        presenter.attachView(this)
    }

    override fun bindCharacter(makeup: Makeup) {
        brandText.text = makeup.name
        nameText.text = makeup.name
        descriptionText.text = makeup.description
        priceText.text = makeup.price

        //saveButton.setOnClickListener {
        //    val updatedCharacter = character.copy(note = noteEditText.text.toString())
        //    presenter.onSaveButtonClicked(updatedCharacter)
        //}
    }
    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.diagonaltranslate,R.anim.alpha)
    }
    override fun closeScreen() {
        finish()
    }
}