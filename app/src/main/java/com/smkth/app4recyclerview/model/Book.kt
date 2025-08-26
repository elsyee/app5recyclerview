package com.smkth.app4recyclerview.model

import com.google.gson.annotations.SerializedName

data class Book(
    @SerializedName("id") val id: Int,
    @SerializedName("judul") val title: String,
    @SerializedName("penulis") val author: String,
    @SerializedName("tahun") val year: Int,
    @SerializedName("cover") val image: String
)
