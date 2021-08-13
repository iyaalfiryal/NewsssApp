package com.iyaliyul.newsssapp.ui.home

import com.iyaliyul.newsssapp.data.model.ArticleItem
import com.xwray.groupie.viewbinding.BindableItem

class MainItem(
    private val article: ArticleItem,
    private val onClick: (ArticleItem) -> Unit
){
}