package com.example.retrofitmovielist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitmovielist.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var kategoriListe:ArrayList<Kategoriler>
    private lateinit var adapter:KategoriAdapter
    private lateinit var kdi:KategorilerDaoInterface
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.kategoriRv.setHasFixedSize(true)
        binding.kategoriRv.layoutManager = LinearLayoutManager(this)

        kdi = ApiUtils.getKategorilerDaoInterface()

        tumKategoriler()


    }

    fun tumKategoriler(){

        kdi.tumKategoriler().enqueue(object : Callback<KategorilerCevap> {
            override fun onResponse(call: Call<KategorilerCevap>?, response: Response<KategorilerCevap>?) {

                if(response != null){
                    val liste = response.body().kategoriler

                    adapter = KategoriAdapter(this@MainActivity,liste)

                    binding.kategoriRv.adapter = adapter
                }

            }

            override fun onFailure(call: Call<KategorilerCevap>?, t: Throwable?) {

            }
        })
    }
}