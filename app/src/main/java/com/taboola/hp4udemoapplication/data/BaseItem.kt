package com.taboola.hp4udemoapplication.data

 open class BaseItem(var type: Int) {

    companion object {
        internal const val HEADER_TYPE = 0
        internal const val ARTICLE_TYPE = 1
    }
}