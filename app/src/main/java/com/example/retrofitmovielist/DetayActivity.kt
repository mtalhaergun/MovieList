package com.example.retrofitmovielist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofitmovielist.databinding.ActivityDetayBinding
import com.squareup.picasso.Picasso

class DetayActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val film = intent.getSerializableExtra("filmNesne") as Filmler

        binding.textViewFilmAd.text = film.film_ad
        binding.textViewFilmYil.text = (film.film_yil).toString()
        binding.textViewYonetmen.text = film.yonetmen.yonetmen_ad

        val url = "http://kasimadalan.pe.hu/filmler/resimler/${film.film_resim}"

        Picasso.get().load(url).into(binding.imageViewResim)
    }
}