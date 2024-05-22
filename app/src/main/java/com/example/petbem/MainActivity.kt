package com.example.petbem

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var getNamePet:TextView
    private lateinit var categoriasImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("petbem_prefs", Context.MODE_PRIVATE)
        val agePet = sharedPreferences.getString("agePet", null)
        val nomePet = sharedPreferences.getString("nomePet", null)
        val racaPet = sharedPreferences.getString("petRaca", null)
        getNamePet = findViewById(R.id.name_pet_resumo)
        getNamePet.text = nomePet

        categoriasImage = findViewById(R.id.categorias_image)
        categoriasImage.setOnClickListener {
            val intent = Intent(this, CategoriesActivity::class.java)
            startActivity(intent)
        }

    }
}