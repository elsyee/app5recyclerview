package com.smkth.app4recyclerview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.smkth.app4recyclerview.model.Book

class BookAdapter(private val context: Context, private val bookList: MutableList<Book>) :
    RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgBook: ImageView = itemView.findViewById(R.id.imgBook)
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvAuthor: TextView = itemView.findViewById(R.id.tvAuthor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_book, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = bookList[position]
        holder.tvTitle.text = book.title
        holder.tvAuthor.text = book.author

        Glide.with(context).load(book.image).into(holder.imgBook)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, BookDetailActivity::class.java).apply {
                putExtra("title", book.title)
                putExtra("author", book.author)
                putExtra("year", book.year.toString()) // ubah ke string
                putExtra("image", book.image)
            }
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int = bookList.size

    fun setData(newBooks: List<Book>) {
        bookList.clear()
        bookList.addAll(newBooks)
        notifyDataSetChanged()
    }
}
