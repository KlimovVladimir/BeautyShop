package com.example.beautyshop.FilterList.SelectorActivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.beautyshop.BeautyShopApplication
import com.example.beautyshop.R
import com.example.beautyshop.data.Filter
import com.example.beautyshop.data.Makeup
import com.squareup.picasso.Picasso

class SelectorAdapter(private val id: Long, private val onItemClick: (String) -> Unit) : RecyclerView.Adapter<SelectorHolder>() {

    var items: MutableList<String> = getFilters( id )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectorHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_selector, parent, false)
        return SelectorHolder(onItemClick, view)
    }

    override fun onBindViewHolder(holder: SelectorHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}

class SelectorHolder(private val onItemClick: (String) -> Unit, itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val nameText: TextView = itemView.findViewById(R.id.nameText)

    fun bind(brands: String) {
        nameText.text = brands
        nameText.setOnClickListener { onItemClick(brands) }
    }
}