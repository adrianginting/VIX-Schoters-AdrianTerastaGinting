package com.adrianterastaginting.mynewsapp.ui.favorite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

class NewsDbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "news.db"
        private const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        val SQL_CREATE_ENTRIES = """
            CREATE TABLE ${ArticleEntry.TABLE_NAME} (
                ${BaseColumns._ID} INTEGER PRIMARY KEY,
                ${ArticleEntry.COLUMN_NAME_TITLE} TEXT,
                ${ArticleEntry.COLUMN_NAME_DESCRIPTION} TEXT,
                ${ArticleEntry.COLUMN_NAME_URL} TEXT,
                ${ArticleEntry.COLUMN_NAME_URL_TO_IMAGE} TEXT,
                ${ArticleEntry.COLUMN_NAME_PUBLISHED_AT} TEXT
            )
        """.trimIndent()

        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL("DROP TABLE IF EXISTS ${ArticleEntry.TABLE_NAME}")
        onCreate(db)
    }
}
