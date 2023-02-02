package com.example.retrofitmovielist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.retrofitmovielist.databinding.ActivityFilmlerBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmlerActivity : AppCompatActivity() {

    private lateinit var filmListe:ArrayList<Filmler>
    private lateinit var adapter:FilmlerAdapter
    private lateinit var fdi:FilmlerDaoInterface
    private lateinit var binding : ActivityFilmlerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilmlerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val kategori = intent.getSerializableExtra("kategoriNesne") as Kategoriler


        binding.filmlerRv.setHasFixedSize(true)
        binding.filmlerRv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        fdi = ApiUtils.getFilmlerDaoInterface()

        tumFilmlerByKategoriId(kategori.kategori_id)



    }

    fun tumFilmlerByKategoriId(kategori_id:Int){
        fdi.tumFilmlerByKategoriId(kategori_id).enqueue(object : Callback<FilmlerCevap> {

            override fun onResponse(call: Call<FilmlerCevap>?, response: Response<FilmlerCevap>?) {

                if(response != null){
                    val liste = response.body().filmler

                    adapter = FilmlerAdapter(this@FilmlerActivity,liste)

                    binding.filmlerRv.adapter = adapter
                }
            }

            override fun onFailure(call: Call<FilmlerCevap>?, t: Throwable?) {

            }

        })
    }
}