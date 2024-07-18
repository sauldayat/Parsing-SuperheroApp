package com.example.superhero

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.superhero.databinding.ActivityMainBinding
import com.example.superhero.model.Superhero
import com.example.superhero.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fetchSuperheroData()
    }

    private fun fetchSuperheroData() {
        RetrofitClient.instance.getSuperhero().enqueue(object : Callback<Superhero> {
            override fun onResponse(call: Call<Superhero>, response: Response<Superhero>) {
                val superhero = response.body()
                if (superhero != null) {
                    displaySuperhero(superhero)
                }
            }

            override fun onFailure(call: Call<Superhero>, t: Throwable) {
                // Handle the error
            }
        })
    }

    private fun displaySuperhero(superhero: Superhero) {
        binding.tvName.text = superhero.name
        binding.tvid.text = "ID : ${superhero.id}"
        binding.tvPowerstats2.text = """
            
            Intelligence : ${superhero.powerstats.intelligence}
            Strength : ${superhero.powerstats.strength}
            Speed : ${superhero.powerstats.speed}
            Durability : ${superhero.powerstats.durability}
            Power : ${superhero.powerstats.power}
            Combat : ${superhero.powerstats.combat}
        """.trimIndent()

        binding.tvBiography2.text = """
            Full Name : ${superhero.biography.`full-name`}
            Alter Egos : ${superhero.biography.`alter-egos`}
            Aliases : ${superhero.biography.aliases}
            Place of Birth : ${superhero.biography.`place-of-birth`}
            First Appearance : ${superhero.biography.`first-appearance`}
            Publisher : ${superhero.biography.publisher}
            Alignment : ${superhero.biography.alignment}
        """.trimIndent()

        binding.tvAppear2.text = """
            Gender : ${superhero.appearance.gender}
            Race : ${superhero.appearance.race}
            Height : ${superhero.appearance.height}
            Weight : ${superhero.appearance.weight}
            Eye Color : ${superhero.appearance.`eye-color`}
            Hair Color : ${superhero.appearance.`hair-color`}
        """.trimIndent()

        binding.tvWork2.text = """
            Work : ${superhero.work}
        """.trimIndent()

        binding.tvConnect2.text = """
            Connections : ${superhero.connections}
        """.trimIndent()
        Glide.with(this)
            .load(superhero.image.url)
            .into(binding.ivImage)
    }
}