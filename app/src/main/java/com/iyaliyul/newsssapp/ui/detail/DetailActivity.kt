package com.iyaliyul.newsssapp.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.iyaliyul.newsssapp.R
import com.iyaliyul.newsssapp.data.model.ArticleItem
import com.iyaliyul.newsssapp.databinding.ActivityDetailBinding
import com.iyaliyul.newsssapp.utils.loadImage

class DetailActivity : AppCompatActivity() {
    private val binding: ActivityDetailBinding by viewBinding()
    private var newsItem: ArticleItem? = null

    companion object {
        const val DETAIL_EXTRA = "detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        // ? (nullable)= nullable or can be null
        // !! (bang operator) = cant be null if null DIE
        // ?: (elvish operator)  = if a is null, otherwise b
        newsItem = intent.extras?.getParcelable(DETAIL_EXTRA)
        newsItem?.let {
            binding.apply {
                detailImage.loadImage(it.urlToImage)
                detailNama.text = it.title
                detailDeskripsi.text = it.description
            }
        }
    }

}