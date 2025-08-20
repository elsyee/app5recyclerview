package com.smkth.app4recyclerview.api

import com.smkth.app4recyclerview.model.Book
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET(".") // titik berarti langsung ke BASE_URL tanpa tambahan path
    fun getBooks(): Call<List<Book>>
}
