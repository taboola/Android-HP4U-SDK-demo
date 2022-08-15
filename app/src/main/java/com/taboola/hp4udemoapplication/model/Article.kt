package com.taboola.hp4udemoapplication.model

data class Article(
    var title: String,
    var content: String,
    var imageUrl: Int,
    var url: String,
    var category: String,
    var sectionName: String
) : BaseItem(ARTICLE_TYPE)
