package com.smkth.app4recyclerview

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class BookDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)

        val imgBookDetail: ImageView = findViewById(R.id.imgBookDetail)
        val tvTitleDetail: TextView = findViewById(R.id.tvTitleDetail)
        val tvAuthorDetail: TextView = findViewById(R.id.tvAuthorDetail)
        val tvYearDetail: TextView = findViewById(R.id.tvYearDetail)

        val title = intent.getStringExtra("title")
        val author = intent.getStringExtra("author")
        val year = intent.getStringExtra("year")
        val image = intent.getStringExtra("image")

        tvTitleDetail.text = title
        tvAuthorDetail.text = author
        tvYearDetail.text = year
        Glide.with(this).load(image).into(imgBookDetail)
    }
}

