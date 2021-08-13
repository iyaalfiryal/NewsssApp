package com.iyaliyul.newsssapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewsResponse(
    val articles: List<ArticleItem>,
    val status: String,
    val totalResults: Int
) : Parcelable