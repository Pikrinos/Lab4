package com.example.lab4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.net.toUri
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab4.databinding.ActivityMainBinding
import com.github.javafaker.Faker


private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val list: MutableList<Place> = mutableListOf()
    private val faker: Faker = Faker()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = PlacesAdapter(layoutInflater)
        binding.list.adapter = adapter
        binding.list.layoutManager = LinearLayoutManager(this)
        adapter.submitList(null)

        binding.add.setOnClickListener {
            val place = Place(faker.company().name(),faker.address().streetName().plus(" ").plus(faker.address().buildingNumber()))
            list.add(place)
            adapter.submitList(list.toList())

        }

        binding.remove.setOnClickListener{
            if(list.isNotEmpty())
                list.removeLast()
            adapter.submitList(list.toList())

        }
        binding.clear.setOnClickListener{
            list.clear()
            adapter.submitList(list.toList())

        }
    }
    data class Place(val name: String, val address: String)
}