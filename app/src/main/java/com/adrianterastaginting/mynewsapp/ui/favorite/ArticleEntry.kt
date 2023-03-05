package com.adrianterastaginting.mynewsapp.ui.favorite

import android.provider.BaseColumns

object ArticleEntry : BaseColumns {
    const val TABLE_NAME = "article"
    const val COLUMN_NAME_TITLE = "title"
    const val COLUMN_NAME_DESCRIPTION = "description"
    const val COLUMN_NAME_URL = "url"
    const val COLUMN_NAME_URL_TO_IMAGE = "url_to_image"
    const val COLUMN_NAME_PUBLISHED_AT = "published_at"
}
