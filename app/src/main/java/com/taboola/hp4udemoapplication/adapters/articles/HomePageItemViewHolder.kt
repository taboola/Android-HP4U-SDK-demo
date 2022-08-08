package com.taboola.hp4udemoapplication.adapters.articles

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.taboola.android.homepage.TBLHomePage
import com.taboola.hp4udemoapplication.R
import com.taboola.hp4udemoapplication.data.Article
import com.taboola.hp4udemoapplication.view.AnimatedBackgroundTextView

class HomePageItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val title: TextView?
        get() = itemView.findViewById(R.id.title)

    private val content: TextView?
        get() = itemView.findViewById(R.id.content)

    private val image: ImageView?
        get() = itemView.findViewById(R.id.image)

    private val animatedBackgroundTextView: AnimatedBackgroundTextView?
        get() = itemView.findViewById(R.id.swapped_indication)

    fun onBind(homePage: TBLHomePage?, position: Int, article: Article) {
        val swappedPerformed: Boolean? = homePage?.shouldSwapItemInSection(
            position,
            article.sectionName,
            itemView,
            title,
            content,
            image,
            null
        )
        if (swappedPerformed == null || !swappedPerformed) {
            animatedBackgroundTextView?.visibility = View.GONE
            title?.text = article.title
            content?.text = article.content
            if (article.imageUrl != 0) {
                Picasso.get().load(article.imageUrl).into(image)
            }
        } else {
            animatedBackgroundTextView?.visibility = View.VISIBLE
        }
    }
}