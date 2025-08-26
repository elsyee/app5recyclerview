package com.smkth.app4recyclerview

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smkth.app4recyclerview.api.ApiService
import com.smkth.app4recyclerview.api.RetrofitClient
import com.smkth.app4recyclerview.model.Book
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: BookAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        adapter = BookAdapter(this, mutableListOf())

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        getBooks()
    }

    private fun getBooks() {
        val api = RetrofitClient.instance.create(ApiService::class.java)
        api.getBooks().enqueue(object : Callback<List<Book>> {
            override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
                if (response.isSuccessful) {
                    val books = response.body() ?: emptyList()
                    Log.d("API_DATA", "Jumlah data: ${books.size}")
                    adapter.setData(books)
                } else {
                    Toast.makeText(this@MainActivity, "Gagal load data: ${response.code()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Book>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                Log.e("API_FAILURE", "Error: ${t.message}")
            }
        })
    }
}
