package com.example.beautyshop.MakeupList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.beautyshop.R
import com.example.beautyshop.data.Makeup

class MakeupListAdapter(private val onItemClick: (Makeup) -> Unit) : RecyclerView.Adapter<MakeupHolder>() {

    var makeups: List<Makeup> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MakeupHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_makeup, parent, false)
        return MakeupHolder(onItemClick, view)
    }

    override fun onBindViewHolder(holder: MakeupHolder, position: Int) {
        val makeup = makeups[position]
        holder.bind(makeup)
    }

    override fun getItemCount(): Int = makeups.size
}

class MakeupHolder(private val onItemClick: (Makeup) -> Unit, itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val nameText: TextView = itemView.findViewById(R.id.nameText)
    private val brandText: TextView = itemView.findViewById(R.id.brandText)

    fun bind(makeup: Makeup) {
        nameText.text = makeup.name
        brandText.text = makeup.brand
        itemView.setOnClickListener { onItemClick(makeup) }
    }
}