package com.example.oyunquzi

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import java.io.File
import java.io.IOException

class AssetDatabaseOpenHelper constructor(
    private val context: Context
) {

    companion object {

        private const val DB_NAME = "karakterquizi.db"
    }

    fun createDataBase() {
        val dbFile = context.getDatabasePath(DB_NAME)
        if (!dbFile.exists()) {
            try {
                val checkDB = context.openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null)
                checkDB?.close()
                copyDatabase(dbFile)
            } catch (e: IOException) {
                throw RuntimeException("Error creating source database", e)
            }
        }
    }



    private fun openDatabase(): SQLiteDatabase {
        val dbFile = context.getDatabasePath(DB_NAME)
        if (!dbFile.exists()) {
            try {
                val checkDB = context.openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null)

                checkDB?.close()
                copyDatabase(dbFile)
            } catch (e: IOException) {
                throw RuntimeException("Error creating source database", e)
            }

        }
        return SQLiteDatabase.openDatabase(dbFile.path, null, SQLiteDatabase.OPEN_READWRITE)
    }

    private fun copyDatabase(dbFile: File?) {
        TODO("Not yet implemented")
    }

    fun crateDataBase() {
        TODO("Not yet implemented")
    }

    fun openDataBase() {
        TODO("Not yet implemented")
    }

}