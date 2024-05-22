package com.example.petbem

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HygieneActivity : AppCompatActivity() {
    private lateinit var rvHygiene: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hygiene)
        val hygieneItem = mutableListOf<HygieneItem>()
        hygieneItem.add(
            HygieneItem(
                id = 1,
                drawableId = R.drawable.med_icon,
                textStringId = R.string.medicamentos,
                color = Color.rgb(233, 30, 99)
            ),

            )
        hygieneItem.add(
            HygieneItem(
                id = 2,
                drawableId = R.drawable.vacina_icon,
                textStringId = R.string.vacinas,
                color = Color.rgb(55, 72, 172)
            ),

            )
        hygieneItem.add(
            HygieneItem(
                id = 3,
                drawableId = R.drawable.higine_icon,
                textStringId = R.string.higiene,
                color = Color.rgb(92, 51, 174)
            ),

            )
        hygieneItem.add(
            HygieneItem(
                id = 4,
                drawableId = R.drawable.lembrete_icon,
                textStringId = R.string.lembretes,
                color = Color.rgb(4, 226, 107)
            ),

            )
        val adapter = MainAdapter(hygieneItem)
        rvHygiene = findViewById(R.id.rv_hygiene)
        rvHygiene.adapter = adapter
        rvHygiene.layoutManager = LinearLayoutManager(this)

    }

    private inner class MainAdapter(
        private val mainItems: List<HygieneItem>,

    ) :
        RecyclerView.Adapter<HygieneActivity.MainViewHolder>() {
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): HygieneActivity.MainViewHolder {
            val view = layoutInflater.inflate(R.layout.activity_hygiene, parent, false)
            return  MainViewHolder(view)
        }

        override fun getItemCount(): Int {
            return mainItems.size
        }

        override fun onBindViewHolder(
            holder: HygieneActivity.MainViewHolder,
            position: Int
        ) {
            val itemCurrent = mainItems[position]
            holder.bind(itemCurrent)
        }

    }

    private class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: HygieneItem) {
            val img: ImageView = itemView.findViewById(R.id.item_img_icon)
            val name: TextView = itemView.findViewById(R.id.item_txt_ctegories)
            val container: LinearLayout = itemView as LinearLayout

            img.setImageResource(item.drawableId)
            name.setText(item.textStringId)
            container.setBackgroundColor(item.color)

        }

    }
}