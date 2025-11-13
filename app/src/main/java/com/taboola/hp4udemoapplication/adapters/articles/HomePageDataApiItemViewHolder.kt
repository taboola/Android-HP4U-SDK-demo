package com.taboola.hp4udemoapplication.adapters.articles

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.taboola.hp4udemoapplication.R
import com.taboola.hp4udemoapplication.model.Article
import com.taboola.hp4udemoapplication.view.AnimatedBackgroundTextView

class HomePageDataApiItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val title: TextView?
        get() = itemView.findViewById(R.id.title)

    private val content: TextView?
        get() = itemView.findViewById(R.id.content)

    private val image: ImageView?
        get() = itemView.findViewById(R.id.image)

    private val animatedBackgroundTextView: AnimatedBackgroundTextView?
        get() = itemView.findViewById(R.id.swapped_indication)

    fun onBind(article: Article) {
        animatedBackgroundTextView?.isVisible = article.isSwapped
        title?.text = article.title
        content?.text = article.content
        if (article.isSwapped) {
            Picasso.get().load(article.url).into(image)
        } else {
            Picasso.get().load(article.imageResourceId).into(image)
        }
    }
}