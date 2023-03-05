package com.adrianterastaginting.mynewsapp.ui.home

import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("top-headlines")
    fun getTopHeadlines(
        @Query("sources") country: String,
        @Query("apiKey") apiKey: String
    ): retrofit2.Call<NewsApiResponse>
}



