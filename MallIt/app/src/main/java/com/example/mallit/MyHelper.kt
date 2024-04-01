package com.example.mallit

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyHelper(context: Context): SQLiteOpenHelper(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION) {
    companion object{
        private const val CREATE_TABLE = "CREATE TABLE ${Constants.TABLE_NAME} (" +
                "${Constants.UID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "${Constants.MALL_NAME} TEXT, " +
                "${Constants.SHOPS_NAME} TEXT, " +
                "${Constants.TYPE} TEXT); "
        private const val DROP_TABLE = "DROP TABLE IF EXISTS ${Constants.TABLE_NAME}"
    }
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(DROP_TABLE)
        onCreate(db)
    }
}