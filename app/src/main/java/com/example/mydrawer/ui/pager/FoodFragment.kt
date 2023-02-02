package com.example.mydrawer.ui.pager

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mydrawer.R
import com.example.mydrawer.adapter.MenuAdapter
import com.example.mydrawer.data.Menu


class FoodFragment : Fragment() {

    private val listFood = ArrayList<Menu>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val dataKode = resources.getStringArray(R.array.menu_kode)
        val dataNama = resources.getStringArray(R.array.menu_nama)
        val dataJenis = resources.getStringArray(R.array.menu_jenis)
        val dataPenjelasan = resources.getStringArray(R.array.menu_penjelasan)
        val dataHarga = resources.getStringArray(R.array.menu_harga)
        if (listFood.isEmpty()) {
            for (i in dataKode.indices) {
                if (dataJenis[i] == MAKANAN) {
                    val menu = Menu(
                        dataKode[i],
                        dataNama[i],
                        dataJenis[i],
                        dataPenjelasan[i],
                        dataHarga[i],
                    )
                    listFood.add(menu)
                }
            }
        }
        return inflater.inflate(R.layout.fragment_food, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvMenu = view.findViewById<RecyclerView>(R.id.rv_food)
        rvMenu.layoutManager = GridLayoutManager(context,2)
        rvMenu.adapter = MenuAdapter(listFood)
    }

    override fun onDestroy() {
        super.onDestroy()
        listFood.clear()
    }
    companion object {
        private const val MAKANAN = "Makanan"
    }

}