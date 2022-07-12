package com.taboola.hp4udemoapplication.adapters.articles

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.taboola.hp4udemoapplication.R
import com.taboola.hp4udemoapplication.data.Header

class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun onBind(header: Header) {
        itemView.findViewById<TextView>(R.id.title).text = header.title
    }
}