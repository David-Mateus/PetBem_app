package com.example.petbem

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RegisterPetActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter
    private lateinit var emptyImageView:LinearLayout
    private val itemList = ArrayList<Pet>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register_pet)
        emptyImageView = findViewById(R.id.linear_layout_isEmpty);
        recyclerView = findViewById(R.id.recyclerView)
        adapter = ItemAdapter(this)


        recyclerView.adapter = adapter
        //inverter a ordem do linearLayoutManager
//        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {

            val intent = Intent(this, Forms_pet::class.java)
            startActivity(intent)

        }
}
    override fun onResume() {
        super.onResume()

        // Atualizar os dados do RecyclerView ao retomar a atividade
        val sharedPreferences = getSharedPreferences("petbem_prefs", Context.MODE_PRIVATE)
        val agePet = sharedPreferences.getString("agePet", null)
        val nomePet = sharedPreferences.getString("nomePet", null)
        val racaPet = sharedPreferences.getString("petRaca", null)
        if (nomePet != null && agePet != null && racaPet != null) {
            val pet = Pet(nomePet, agePet, racaPet)
            if (!itemList.contains(pet)) {
                itemList.add(pet)
                adapter.notifyItemInserted(itemList.size - 1)
                checkIfEmpty()
            }
        }
    }

    private fun checkIfEmpty() {
        if (itemList.isEmpty()) {
            emptyImageView.visibility = View.VISIBLE
            recyclerView.visibility = View.GONE
        } else {
            emptyImageView.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
        }
    }


    private inner class ItemAdapter(private val context: Context) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

        inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val linearLayoutItem: LinearLayout = itemView.findViewById(R.id.list_linear_layout)
            val textViewItem: TextView = itemView.findViewById(R.id.text_name_pet)


            init {
                linearLayoutItem.setOnClickListener {
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                }
            }
        }



        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
            return ItemViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
            val item = itemList[position]
            Log.d("test", "Tamanho da lista após adição: ${itemList.size}")
            holder.textViewItem.text = item.nome


        }

        override fun getItemCount(): Int {
            return itemList.size
        }
    }

}