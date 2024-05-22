package com.example.petbem

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Forms_pet : AppCompatActivity() {
    private lateinit var btnAddPet : Button
    private lateinit var nameInput: EditText
    private lateinit var petAgeInput: EditText
    private lateinit var petRacaInput: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_forms_pet)
        nameInput = findViewById(R.id.petNameInput)
        btnAddPet = findViewById(R.id.addPetButton)
        petAgeInput = findViewById(R.id.petAgeInput)
        petRacaInput = findViewById(R.id.petBreedInput)
        btnAddPet.setOnClickListener {

            val nomePet = nameInput.text.toString()
            val agePet = petAgeInput.text.toString()
            val petRaca = petRacaInput.text.toString()

            // Armazenar temporariamente os dados do formulário usando SharedPreferences
            val sharedPreferences = getSharedPreferences("petbem_prefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("nomePet", nomePet)
            editor.putString("agePet", agePet)
            editor.putString("petRaca", petRaca )
            editor.apply()
            finish()
        }

    }
}