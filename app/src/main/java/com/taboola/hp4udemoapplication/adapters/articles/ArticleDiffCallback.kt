package com.taboola.hp4udemoapplication.adapters.articles

import androidx.recyclerview.widget.DiffUtil
import com.taboola.hp4udemoapplication.model.Article
import com.taboola.hp4udemoapplication.model.BaseItem
import com.taboola.hp4udemoapplication.model.BaseItem.Companion.HEADER_TYPE
import com.taboola.hp4udemoapplication.model.Header

class ArticleDiffCallback(
    private val oldArticles: ArrayList<BaseItem>,
    private val newArticles: ArrayList<BaseItem>
) : DiffUtil.Callback() {


    override fun getOldListSize(): Int = oldArticles.size
    override fun getNewListSize(): Int = newArticles.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldArticles[oldItemPosition].type == newArticles[newItemPosition].type

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldArticles[oldItemPosition]
        val newItem = newArticles[newItemPosition]
        return if (oldItem.type == HEADER_TYPE) {
            (oldItem as Header).title == (newItem as Header).title
        } else {
            ((oldItem as Article).title == (newItem as Article).title
                    && oldItem.content == newItem.content
                    && oldItem.imageUrl == newItem.imageUrl
                    && oldItem.url == newItem.url
                    && oldItem.category == newItem.category)
        }
    }
}