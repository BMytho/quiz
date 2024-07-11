package com.example.oyunquzi

import android.annotation.SuppressLint

class Karakterlerdao {

    @SuppressLint("Range", "Recycle")
    fun rastgele5KarakterGetir(vt:Veritabaniyardimcisi) :ArrayList<Karakterler> {

        val karakterlerliste = ArrayList<Karakterler>()
        val db = vt.writableDatabase
        val c = db.rawQuery("SELECT * FROM karakter ORDER BY RANDOM LIMIT 5",null)

        while (c.moveToNext()){

           val karakter = Karakterler(c.getInt(c.getColumnIndex("karakter_id"))
           ,c.getString(c.getColumnIndex("karakter_ad"))
           ,c.getString(c.getColumnIndex("karakter_resim")))

            karakterlerliste.add(karakter)
    }
        return karakterlerliste



}
    @SuppressLint("Range", "Recycle")
    fun rastgele3YanlisSecenekGetir(vt:Veritabaniyardimcisi, karakter_id : Int) :ArrayList<Karakterler> {

        val karakterlerliste = ArrayList<Karakterler>()
        val db = vt.writableDatabase
        val c = db.rawQuery("SELECT * FROM karakter WHERE karakter_id != $karakter_id ORDER BY RANDOM LIMIT 3",null)

        while (c.moveToNext()){

            val karakter = Karakterler(c.getInt(c.getColumnIndex("karakter_id"))
                ,c.getString(c.getColumnIndex("karakter_ad"))
                ,c.getString(c.getColumnIndex("karakter_resim")))

            karakterlerliste.add(karakter)
        }
        return karakterlerliste



    }

}