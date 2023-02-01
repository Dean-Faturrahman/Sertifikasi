package com.example.mydrawer.ui.pager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mydrawer.R
import com.example.mydrawer.adapter.MenuAdapter
import com.example.mydrawer.data.Menu

class DessertFragment : Fragment() {

    private val listDessert = ArrayList<Menu>()

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
        for (i in dataKode.indices) {
            if (dataJenis[i] == DESSERT) {
                val menu = Menu(
                    dataKode[i],
                    dataNama[i],
                    dataJenis[i],
                    dataPenjelasan[i],
                    dataHarga[i],
                )
                listDessert.add(menu)
            }
        }
        return inflater.inflate(R.layout.fragment_dessert, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvMenu = view.findViewById<RecyclerView>(R.id.rv_dessert)
        rvMenu.layoutManager = GridLayoutManager(context,2)
        rvMenu.adapter = MenuAdapter(listDessert)
    }

    companion object {
        private const val DESSERT = "Dessert"
    }

}