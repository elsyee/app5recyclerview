package com.smkth.app4recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smkth.app4recyclerview.model.Book
import androidx.recyclerview.widget.DividerItemDecoration


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(
            DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        )


        val bookList = listOf(
            Book(
                "Laskar Pelangi",
                "Andrea Hirata",
                "2005",
                R.drawable.laskar,
                "Novel ini bercerita tentang perjuangan sepuluh anak dari keluarga miskin di Belitung untuk mendapatkan pendidikan."
            ),
            Book(
                "Bumi Manusia",
                "Pramoedya Ananta Toer",
                "1980",
                R.drawable.bumi,
                "Mengisahkan kehidupan Minke, seorang pribumi cerdas yang jatuh cinta pada Annelies di masa kolonial Belanda."
            ),
            Book(
                "Negeri 5 Menara",
                "Ahmad Fuadi",
                "2009",
                R.drawable.negeri,
                "Perjalanan Alif di pesantren yang penuh mimpi, persahabatan, dan motivasi untuk menaklukkan dunia."
            ),
            Book(
                "Sang Pemimpi",
                "Andrea Hirata",
                "2006",
                R.drawable.sang,
                "Melanjutkan kisah Ikal dan Arai yang berjuang untuk mengejar mimpi hingga ke Paris."
            ),
            Book(
                "Ronggeng Dukuh Paruk",
                "Ahmad Tohari",
                "1982",
                R.drawable.ronggeng,
                "Menggambarkan kehidupan Srintil sebagai ronggeng di desa kecil, dengan konflik sosial dan politik."
            )
        )


        val adapter = BookAdapter(this, bookList)
        recyclerView.adapter = adapter
    }
}
