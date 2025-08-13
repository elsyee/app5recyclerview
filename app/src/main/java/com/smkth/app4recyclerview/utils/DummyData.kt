package com.smkth.app4recyclerview.utils

import com.smkth.app4recyclerview.R
import com.smkth.app4recyclerview.model.Book

object DummyData {
    fun getBooks(): List<Book> {
        return listOf(
            Book(
                "Laskar Pelangi",
                "Andrea Hirata",
                "2005",
                R.drawable.laskar,
                "Bercerita tentang perjuangan 10 anak di Belitung yang berjuang meraih pendidikan meski serba kekurangan."
            ),
            Book(
                "Bumi Manusia",
                "Pramoedya Ananta Toer",
                "1980",
                R.drawable.bumi,
                "Kisah Minke, pemuda pribumi cerdas yang jatuh cinta pada Annelies di tengah penjajahan Belanda."
            ),
            Book(
                "Negeri 5 Menara",
                "Ahmad Fuadi",
                "2009",
                R.drawable.negeri,
                "Perjalanan Alif di pesantren yang penuh persahabatan, mimpi besar, dan motivasi untuk menaklukkan dunia."
            ),
            Book(
                "Sang Pemimpi",
                "Andrea Hirata",
                "2006",
                R.drawable.sang,
                "Kelanjutan kisah Ikal dan Arai yang penuh semangat mengejar impian hingga ke Paris."
            ),
            Book(
                "Ronggeng Dukuh Paruk",
                "Ahmad Tohari",
                "1982",
                R.drawable.ronggeng,
                "Menggambarkan kehidupan Srintil sebagai ronggeng di desa kecil, sarat konflik sosial dan politik."
            )
        )
    }
}
