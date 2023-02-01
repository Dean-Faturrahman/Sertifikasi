package com.example.mydrawer.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Menu(
    var kode: String,
    var nama: String,
    var jenis: String,
    var penjelasan: String,
    var harga: String
) : Parcelable
