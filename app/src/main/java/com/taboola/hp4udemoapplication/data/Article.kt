package com.taboola.hp4udemoapplication.data

data class Article(
    var title: String,
    var content: String,
    var imageUrl: String,
    var url: String,
    var category: String
) : BaseItem(ARTICLE_TYPE)
