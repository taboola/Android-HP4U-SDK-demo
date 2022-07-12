package com.taboola.hp4udemoapplication.adapters.articles

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.taboola.android.homepage.TBLHomePage
import com.taboola.hp4udemoapplication.R
import com.taboola.hp4udemoapplication.data.Article
import com.taboola.hp4udemoapplication.data.BaseItem
import com.taboola.hp4udemoapplication.data.Header

class HomePageAdapter(
    private var homePage: TBLHomePage?,
    private val onItemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val data = ArrayList<BaseItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layout = when (viewType) {
            MAIN_ARTICLE -> R.layout.main_article_item_view
            DEFAULT_ARTICLE -> R.layout.article_item_view
            HEADER -> R.layout.articles_header_view
            else -> throw IllegalArgumentException("Invalid type")
        }

        val view = LayoutInflater
            .from(parent.context)
            .inflate(layout, parent, false)

        return when (viewType) {
            MAIN_ARTICLE -> {
                val mainItemViewHolder = MainHomePageItemViewHolder(view)
                view.setOnClickListener {
                    val url = (data[mainItemViewHolder.adapterPosition] as Article).url
                    onItemClickListener.onClick(url)
                }
                return mainItemViewHolder
            }
            DEFAULT_ARTICLE -> {

                val viewHolder = HomePageItemViewHolder(view)
                view.setOnClickListener {
                    val url = (data[viewHolder.adapterPosition] as Article).url
                    onItemClickListener.onClick(url)
                }
                return viewHolder
            }
            HEADER -> HeaderViewHolder(view)
            else -> throw IllegalArgumentException("Invalid type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            MAIN_ARTICLE -> if (data[position] is Article) {
                (holder as MainHomePageItemViewHolder).onBind(data[position] as Article)
            }
            DEFAULT_ARTICLE -> if (data[position] is Article) {
                (holder as HomePageItemViewHolder).onBind(
                    homePage,
                    position,
                    data[position] as Article
                )
            }
            HEADER -> if (data[position] is Header) {
                (holder as HeaderViewHolder).onBind(data[position] as Header)
            }
            else -> throw IllegalArgumentException("Invalid type")
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return MAIN_ARTICLE
        }
        return if (data[position].type == BaseItem.HEADER_TYPE)
            HEADER
        else
            DEFAULT_ARTICLE
    }

    override fun getItemCount(): Int = data.size

    fun setData(newData: ArrayList<BaseItem>) {
        val diffCallback = ArticleDiffCallback(data, newData)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        data.clear()
        data.addAll(newData)
        diffResult.dispatchUpdatesTo(this)
    }

    companion object {
        private const val HEADER = 0
        private const val MAIN_ARTICLE = 1
        private const val DEFAULT_ARTICLE = 2
    }

    interface OnItemClickListener {
        fun onClick(url: String)
    }
}