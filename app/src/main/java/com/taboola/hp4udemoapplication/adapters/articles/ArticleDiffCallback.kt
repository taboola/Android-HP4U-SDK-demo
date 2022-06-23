package com.taboola.hp4udemoapplication.adapters.articles

import androidx.recyclerview.widget.DiffUtil
import com.taboola.hp4udemoapplication.data.Article
import com.taboola.hp4udemoapplication.data.BaseItem
import com.taboola.hp4udemoapplication.data.BaseItem.Companion.HEADER_TYPE
import com.taboola.hp4udemoapplication.data.Header

class ArticleDiffCallback(
    private val oldArticles: ArrayList<BaseItem>,
    private val newArticles: ArrayList<BaseItem>
) : DiffUtil.Callback() {


    override fun getOldListSize(): Int = oldArticles.size
    override fun getNewListSize(): Int = newArticles.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldArticles[oldItemPosition].type == newArticles[newItemPosition].type

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return if (oldArticles[oldItemPosition].type == HEADER_TYPE) {
            (oldArticles[oldItemPosition] as Header).title.equals((newArticles[newItemPosition] as Header))
        } else {
            ((oldArticles[oldItemPosition] as Article).title == (newArticles[newItemPosition] as Article).title
                    && (oldArticles[oldItemPosition] as Article).content == (newArticles[newItemPosition] as Article).content
                    && (oldArticles[oldItemPosition] as Article).imageUrl == (newArticles[newItemPosition] as Article).imageUrl
                    && (oldArticles[oldItemPosition] as Article).url == (newArticles[newItemPosition] as Article).url
                    && (oldArticles[oldItemPosition] as Article).category == (newArticles[newItemPosition] as Article).category)
        }
    }
}