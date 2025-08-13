package com.smkth.app4recyclerview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.smkth.app4recyclerview.detail.BookDetailActivity
import com.smkth.app4recyclerview.model.Book

class BookAdapter(
    private val context: Context,
    private val bookList: MutableList<Book> // <- ubah jadi MutableList
) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgBook: ImageView = itemView.findViewById(R.id.imgBook)
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvAuthor: TextView = itemView.findViewById(R.id.tvAuthor)
        val tvYear: TextView = itemView.findViewById(R.id.tvYear)
        val btnDelete: ImageButton = itemView.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_book, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = bookList[position]
        holder.imgBook.setImageResource(book.imageResId)
        holder.tvTitle.text = book.title
        holder.tvAuthor.text = book.author
        holder.tvYear.text = book.year

        // Klik item → tampilkan Toast
        holder.itemView.setOnClickListener {
            Toast.makeText(context, "Membuka ${book.title}", Toast.LENGTH_SHORT).show()

            val intent = Intent(context, BookDetailActivity::class.java)
            intent.putExtra("title", book.title)
            intent.putExtra("author", book.author)
            intent.putExtra("year", book.year)
            intent.putExtra("image", book.imageResId)
            intent.putExtra("story", book.description) // tambahkan
            context.startActivity(intent)
        }

        // Klik tombol delete → tampilkan dialog konfirmasi
        holder.btnDelete.setOnClickListener {
            AlertDialog.Builder(context)
                .setTitle("Hapus Buku")
                .setMessage("Apakah kamu yakin ingin menghapus \"${book.title}\"?")
                .setPositiveButton("Ya") { _, _ ->
                    bookList.removeAt(position)
                    notifyItemRemoved(position)
                    notifyItemRangeChanged(position, bookList.size)
                    Toast.makeText(context, "Buku dihapus", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Batal", null)
                .show()
        }
    }

    override fun getItemCount(): Int = bookList.size
}
