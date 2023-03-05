package com.adrianterastaginting.mynewsapp.ui.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adrianterastaginting.mynewsapp.databinding.NewsItemBinding
import com.adrianterastaginting.mynewsapp.ui.home.Article
import com.bumptech.glide.Glide

class FavoritAdapter(private val onItemClick: (Article) -> Unit) : RecyclerView.Adapter<FavoritAdapter.FavoritViewHolder>() {

    private var articles = emptyList<Article>()

    fun setArticles(articles: List<Article>) {
        this.articles = articles
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritViewHolder {
        val binding = NewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoritViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoritViewHolder, position: Int) {
        val article = articles[position]
        holder.bind(article)
    }

    override fun getItemCount(): Int = articles.size

    inner class FavoritViewHolder(private val binding: NewsItemBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val article = articles[position]
                    onItemClick(article)
                }
            }
        }

        fun bind(article: Article) {
            binding.newsTitleTextView.text = article.title
            binding.newsDescriptionTextView.text = article.description
            binding.newsDateTextView.text = article.publishedAt
            Glide
                .with(binding.newsImageView.context)
                .load(article.urlToImage)
                .centerCrop()
                .into(binding.newsImageView)
        }
    }
}
