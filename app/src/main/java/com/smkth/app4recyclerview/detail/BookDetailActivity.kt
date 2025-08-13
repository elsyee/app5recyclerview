package com.smkth.app4recyclerview.detail

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.smkth.app4recyclerview.R

class BookDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)

        val imgBook = findViewById<ImageView>(R.id.imgBookDetail)
        val tvTitle = findViewById<TextView>(R.id.tvTitleDetail)
        val tvAuthor = findViewById<TextView>(R.id.tvAuthorDetail)
        val tvYear = findViewById<TextView>(R.id.tvYearDetail)
        val tvStory = findViewById<TextView>(R.id.tvStoryDetail)

        val title = intent.getStringExtra("title")
        val author = intent.getStringExtra("author")
        val year = intent.getStringExtra("year")
        val image = intent.getIntExtra("image", 0)
        val story = intent.getStringExtra("story")

        imgBook.setImageResource(image)
        tvTitle.text = title
        tvAuthor.text = author
        tvYear.text = year
        tvStory.text = story
    }
}
