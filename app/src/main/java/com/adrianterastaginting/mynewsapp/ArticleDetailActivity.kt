package com.adrianterastaginting.mynewsapp

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.adrianterastaginting.mynewsapp.databinding.ActivityArticleDetailBinding
import com.adrianterastaginting.mynewsapp.ui.favorite.ArticleEntry
import com.adrianterastaginting.mynewsapp.ui.favorite.NewsDbHelper
import com.adrianterastaginting.mynewsapp.ui.home.Article
import com.bumptech.glide.Glide

class ArticleDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArticleDetailBinding
    private lateinit var article: Article


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val article = intent.getParcelableExtra<Article>("article")

        binding.articleTitleTextView.text = article?.title
        binding.articlePublishedAtTextView.text = article?.publishedAt
        binding.articleDescriptionTextView.text = article?.description
        Glide
            .with(this)
            .load(article?.urlToImage)
            .centerCrop()
            .into(binding.articleImageView)


        binding.floatingActionButton.setOnClickListener {
            Toast.makeText(this, "Title: $article?.title \n Desc: $article?.publishedAt",Toast.LENGTH_LONG).show()
            saveArticle()
        }
    }

    private fun saveArticle() {
        val dbHelper = NewsDbHelper(this)
        val db = dbHelper.writableDatabase

        val values = ContentValues().apply {
            put(ArticleEntry.COLUMN_NAME_TITLE, article.title)
            put(ArticleEntry.COLUMN_NAME_DESCRIPTION, article.description)
            put(ArticleEntry.COLUMN_NAME_URL_TO_IMAGE, article.urlToImage)
            put(ArticleEntry.COLUMN_NAME_PUBLISHED_AT, article.publishedAt)
        }

        val newRowId = db.insert(ArticleEntry.TABLE_NAME, null, values)
        if (newRowId == -1L) {
            Toast.makeText(this, "Failed to save article", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Article saved", Toast.LENGTH_SHORT).show()
        }
    }


}

