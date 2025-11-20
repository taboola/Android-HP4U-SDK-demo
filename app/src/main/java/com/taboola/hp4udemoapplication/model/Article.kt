package com.taboola.hp4udemoapplication.model

data class Article(
    var title: String,
    var content: String,
    var imageResourceId: Int,
    var url: String,
    var category: String,
    var sectionName: String,
    var isSwapped: Boolean = false
) : BaseItem(ARTICLE_TYPE)