package com.example.oyunquzi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.oyunquzi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        veritabaniKopyala()

        binding.buttonBasla.setOnClickListener(){

            startActivity(Intent(this@MainActivity,QuizActivity::class.java))


        }
    }

    fun veritabaniKopyala(){

        val copyHelper = AssetDatabaseOpenHelper(this)

        try {
            copyHelper.crateDataBase()
            copyHelper.openDataBase()

        }catch (e:Exception){
            e.printStackTrace()
        }




    }



}