package com.example.oyunquzi

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Veritabaniyardimcisi(context: Context) : SQLiteOpenHelper(context,"karakter.db",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL( "CREATE TABLE IF NOT EXISTS 'karakterquizi' (\n" +
            "\t 'karakter_id' \tINTEGER PRİMARY KEY AUTOINCREMENT,\n" +
            "\t 'karakter_ad'\tTEXT,\n" +
            "\t 'karakter_resim'\tTEXT\n"+
            ");")



    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS karakterquizi")
        onCreate(db)
    }
}

