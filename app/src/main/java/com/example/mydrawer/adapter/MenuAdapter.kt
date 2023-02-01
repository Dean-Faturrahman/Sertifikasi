package com.example.mydrawer.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mydrawer.R
import com.example.mydrawer.data.Menu

class MenuAdapter(private val listMenu: ArrayList<Menu>) : RecyclerView.Adapter<MenuAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvKode: TextView = itemView.findViewById(R.id.kode_menu)
        var tvNama: TextView = itemView.findViewById(R.id.nama_menu)
        var tvPenjelasan: TextView = itemView.findViewById(R.id.penjelasan_menu)
        var tvHarga: TextView = itemView.findViewById(R.id.harga_menu)
        var imgMenu: ImageView = itemView.findViewById(R.id.img_menu)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listMenu.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (kode, nama, jenis, penjelasan, harga) = listMenu[position]
        holder.tvKode.text = "Kode : $kode"
        holder.imgMenu.setImageResource(R.drawable.dummy_image)
        holder.tvNama.text = nama
        holder.tvPenjelasan.text = penjelasan
        holder.tvHarga.text = "Rp$harga"
    }
}