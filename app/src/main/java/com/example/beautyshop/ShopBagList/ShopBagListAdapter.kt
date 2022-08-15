package com.example.beautyshop.ShopBagList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.beautyshop.BeautyShopApplication
import com.example.beautyshop.R
import com.example.beautyshop.data.Makeup
import com.squareup.picasso.Picasso

class ShopBagListAdapter(private val onItemClick: (Makeup) -> Unit) : RecyclerView.Adapter<ShopBagHolder>() {

    var shops: List<Makeup> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopBagHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_makeup, parent, false)
        return ShopBagHolder(onItemClick, view)
    }

    override fun onBindViewHolder(holder: ShopBagHolder, position: Int) {
        val makeup = shops[position]
        holder.bind(makeup)
    }

    override fun getItemCount(): Int = shops.size
}

class ShopBagHolder(private val onItemClick: (Makeup) -> Unit, itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val nameText: TextView = itemView.findViewById(R.id.nameText)
    private val brandText: TextView = itemView.findViewById(R.id.brandText)
    private val priceText: TextView = itemView.findViewById(R.id.priceText)
    private val image: ImageView = itemView.findViewById(R.id.image)

    fun bind(makeup: Makeup) {
        var price = ""
        Picasso.get().load(makeup.image_link).into(image)
        nameText.text = makeup.name
        brandText.text = makeup.brand
        if (makeup.price == "0.0")
            price = "Нет в наличии"
        else if (makeup.price_sign == null)
            price = makeup.price + " $"
        else
            price = makeup.price + " " + makeup.price_sign
        priceText.text = price

        itemView.setOnClickListener { onItemClick(makeup) }
    }
}