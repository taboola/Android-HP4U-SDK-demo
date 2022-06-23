package com.taboola.hp4udemoapplication.adapters.articles

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.taboola.hp4udemoapplication.R
import com.taboola.hp4udemoapplication.data.Article

class HomePageItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val title: TextView?
        get() = itemView.findViewById(R.id.title)

    private val content: TextView?
        get() = itemView.findViewById(R.id.content)

    private val image: ImageView?
        get() = itemView.findViewById(R.id.image)

    fun onBind(article: Article) {
        title?.text = article.title
        content?.text = article.content
        if (article.imageUrl.isNotEmpty()) {
            Picasso.get().load(article.imageUrl).into(image)
        }
    }
}