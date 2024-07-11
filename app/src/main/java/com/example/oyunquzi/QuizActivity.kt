package com.example.oyunquzi

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.oyunquzi.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizBinding

    private lateinit var  sorular : ArrayList<Karakterler>
    private lateinit var  yanlisSecenekler : ArrayList<Karakterler>
    private lateinit var  dogruSoru : Karakterler
    private lateinit var  tumSecenekler : HashSet<Karakterler>
    private lateinit var  vt : Veritabaniyardimcisi

    private var soruSayac = 0
    private var dogruSayac = 0
    private var yanlisSayac = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityQuizBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        vt = Veritabaniyardimcisi(this)

        sorular = Karakterlerdao().rastgele5KarakterGetir(vt)

        soruYukle()

        binding.buttonA.setOnClickListener(){

            soruSayacKontrol()

        }

    }

    @SuppressLint("SetTextI18n", "DiscouragedApi")
    fun soruYukle(){
        binding.textViewSoruSayisi.text = "${soruSayac+1}. Soru"

        dogruSoru = sorular.get(soruSayac)

        binding.imageView2.setImageResource(resources.getIdentifier(dogruSoru.karakter_resim,"drawble",packageName))

        yanlisSecenekler = Karakterlerdao().rastgele3YanlisSecenekGetir(vt,dogruSoru.karakter_id)

        tumSecenekler = HashSet()
        tumSecenekler.add(dogruSoru)
        tumSecenekler.add(yanlisSecenekler.get(0))
        tumSecenekler.add(yanlisSecenekler.get(1))
        tumSecenekler.add(yanlisSecenekler.get(2))

        binding.buttonA.text = tumSecenekler.elementAt(0).karakter_adi
        binding.buttonB.text = tumSecenekler.elementAt(1).karakter_adi
        binding.buttonC.text = tumSecenekler.elementAt(2).karakter_adi
        binding.buttonD.text = tumSecenekler.elementAt(3).karakter_adi



    }

    fun soruSayacKontrol(){
        soruSayac++
        if (soruSayac != 5){
            soruYukle()
        }else{
            startActivity(Intent(this@QuizActivity,ResultActivity::class.java))
            finish()
        }

    }


}