package com.iyaliyul.newsssapp.data.source

import com.iyaliyul.newsssapp.data.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("top-headlines")
    suspend fun fetchNews(
        @Query("sources") source: String?,
        @Query("apiKey") apikey: String?,
    ): NewsResponse
}