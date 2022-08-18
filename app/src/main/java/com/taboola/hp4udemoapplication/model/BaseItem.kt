package com.taboola.hp4udemoapplication.model

 open class BaseItem(var type: Int) {

    companion object {
        internal const val HEADER_TYPE = 0
        internal const val ARTICLE_TYPE = 1
    }
}