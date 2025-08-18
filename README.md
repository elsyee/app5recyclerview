- Tugas RecycleView
  RecyclerView adalah komponen di Android yang digunakan untuk menampilkan data dalam bentuk daftar atau grid secara efisien.
  Tugas ini bertujuan agar kita memahami cara menampilkan data dalam jumlah banyak dengan tampilan yang rapi, ringan, dan mudah diatur.

  - Aplikasi RecycleView // APK Buku Perpustakaan
    Aplikasi RecyclerView Perpustakaan Buku adalah aplikasi sederhana yang digunakan untuk menampilkan daftar koleksi buku dalam perpustakaan.
    Dengan menggunakan komponen RecyclerView, data buku seperti judul, penulis, dan gambar sampul dapat ditampilkan secara rapi, efisien, dan mudah diakses.

  - Nama Anggota
    1. Cahyo Budi (08)
    2. Damasa Shafa Ariella Rahayu (10)
    3. Efanda Reyo Saputra (11)
    4. Elsye Sukma Argita (12)
   
  - Penjelasan Alur Data
    Alur data pada aplikasi ini diawali dari SplashActivity, yang menampilkan layar pembuka selama beberapa detik. Setelah itu, pengguna dialihkan ke MainActivity yang berisi daftar koleksi buku. Informasi buku didefinisikan pada kelas Book sebagai model, yang menyimpan atribut berupa judul, penulis, tahun terbit, serta gambar sampul.
    Data tersebut dihasilkan dari kelas DummyData, kemudian diteruskan ke BookAdapter yang berperan sebagai jembatan antara data dan tampilan pada RecyclerView.
    Adapter menempatkan setiap informasi buku ke dalam layout item (item_book.xml) yang terdiri dari komponen TextView dan ImageView.

  Jika pengguna memilih salah satu buku, data buku dikirim melalui Intent menuju DetailActivity, 
  dengan membawa informasi lengkap berupa judul, penulis, tahun, dan gambar. Pada DetailActivity, data tersebut ditampilkan kembali dalam tampilan yang lebih rinci 
  sehingga pengguna bisa melihat detail buku yang dipilih. Dengan demikian, 
  alur data berjalan dari model → adapter → RecyclerView → intent → DetailActivity, sehingga seluruh informasi buku dapat tersaji secara lengkap dan interaktif.

  - Fitur Aplikasi
1.Splash Screen
Menampilkan logo atau nama perpustakaan selama beberapa detik sebelum masuk ke halaman utama.

2.RecyclerView
Menampilkan daftar minimal 5 buku dengan informasi judul, penulis, dan tahun terbit. Tampilan daftar menggunakan CardView agar lebih rapi dan menarik.

3.Intent
Jika salah satu buku dipilih, aplikasi akan membuka DetailActivity untuk menampilkan informasi lengkap mengenai buku tersebut.

4.Toast Message
Saat pengguna memilih buku, aplikasi menampilkan pesan singkat sebagai notifikasi.

5.Tombol Hapus
Disediakan tombol “Hapus” pada setiap item daftar buku. Ketika tombol ini ditekan, 
data buku yang dipilih akan dihapus dari daftar RecyclerView, dan daftar otomatis diperbarui sehingga buku tersebut tidak lagi muncul.

- Alat dan Bahan
  1.Android Studio
  2.GitHub

- Penjelasab Code Penting

  1. Main Activity
     <img width="960" height="540" alt="image" src="https://github.com/user-attachments/assets/94d4f735-274d-41b4-92c0-a93200f7b97d" />
     <img width="401" height="100" alt="image" src="https://github.com/user-attachments/assets/8f3ba05e-790e-4b91-975a-a4063358b880" />

     Pada MainActivity, kode ini bertugas menampilkan daftar buku dengan cara menghubungkan activity ke layout activity_main.xml, mengambil komponen RecyclerView dari layout, mengatur tampilannya menggunakan LinearLayoutManager agar data tersusun vertikal,
     menambahkan DividerItemDecoration supaya ada garis pemisah antar item, serta membuat daftar data buku (bookList) yang berisi judul, penulis, tahun terbit, gambar,
     dan deskripsi, lalu data tersebut nantinya akan dikirim ke Adapter untuk diolah dan ditampilkan pada RecyclerView.
     Data buku yang dibuat di MainActivity dimasukkan ke dalam Adapter, lalu Adapter menghubungkan data tersebut dengan layout item (TextView dan ImageView),
     kemudian RecyclerView menampilkan daftar buku sesuai tata letak yang diatur oleh LayoutManager.

  2. AndroidManifest.xml
     <img width="960" height="540" alt="image" src="https://github.com/user-attachments/assets/3d06d59e-c62a-4821-8b08-38f5c9b00929" />
     <img width="484" height="182" alt="image" src="https://github.com/user-attachments/assets/e807312c-95c4-4367-9300-dede4ac70048" />

    Saat aplikasi dijalankan, sistem membaca AndroidManifest.xml dan karena SplashActivity diberi MAIN dan LAUNCHER, layar splash muncul selama ±2–3 detik;
    di akhir durasi itu SplashActivity menjalankan Intent ke MainActivity lalu menutup diri. Di MainActivity, setContentView(activity_main) memuat layout yang berisi
    RecyclerView, komponen ini di-findViewById, diberi LinearLayoutManager vertikal dan DividerItemDecoration agar tiap baris terpisah rapi, lalu diisi data dari
    DummyData berupa MutableList<Book>—setiap Book menyimpan judul, penulis, tahun terbit, sampul, dan (opsional) deskripsi. Daftar tersebut diserahkan ke BookAdapter
    yang membuat serta mengikat ViewHolder ke layout item (item_book.xml, biasanya berupa CardView berisi ImageView sampul dan TextView judul/penulis/tahun),
    sekaligus memasang callback untuk interaksi: ketika pengguna mengetuk item atau tombol “Lihat Buku”, adapter memunculkan AlertDialog konfirmasi;
    jika disetujui, callback mengirim data buku melalui Intent extras (putExtra judul, penulis, tahun, id gambar, dll.) ke DetailActivity sambil menampilkan Toast sebagai umpan balik.
    Di DetailActivity, data diambil kembali dari intent (get*Extra) lalu diikat ke komponen tampilan (ImageView.setImageResource, TextView.setText)
    sehingga detail buku terlihat utuh. Jika tersedia tombol Hapus pada item, adapter menghapus elemen terkait dari list,
    memanggil notifyItemRemoved()/notifyItemRangeChanged() agar RecyclerView langsung menyegarkan tampilan, dan menampilkan Toast “Buku dihapus”.
    Dengan demikian, alur lengkapnya: navigasi layar SplashActivity → MainActivity → (Dialog/Toast) → DetailActivity, sementara alur datanya DummyData/Model Book → Adapter → RecyclerView (interaksi) → Intent extras → DetailActivity (render detail).

  3. Book Adapter
     <img width="655" height="356" alt="image" src="https://github.com/user-attachments/assets/a7123975-b71a-49d6-bd31-e986bf84ea72" />
     Dalam kode BookAdapter, adapter ini berfungsi sebagai penghubung antara data daftar buku dengan tampilan RecyclerView. Adapter menerima dua parameter,
     yaitu context untuk mengakses resource dan bookList yang berisi data buku dalam bentuk MutableList, sehingga daftar tersebut masih bisa diubah, misalnya
     ditambah atau dihapus. Di dalam adapter terdapat kelas BookViewHolder yang menyimpan referensi setiap komponen tampilan dari layout item_book.xml, seperti
     gambar sampul buku (imgBook), judul (tvTitle), penulis (tvAuthor), tahun terbit (tvYear), serta tombol hapus (btnDelete). Dengan adanya ViewHolder, proses
     pencarian komponen tampilan menjadi lebih efisien karena tidak perlu memanggil findViewById berulang kali. Selanjutnya, method onCreateViewHolder akan dipanggil
     ketika RecyclerView membutuhkan tampilan item baru. Pada tahap ini, layout item_book.xml di-inflate menjadi sebuah tampilan nyata, lalu dikirimkan ke BookViewHolder
     agar setiap komponen tampilan bisa digunakan. Nantinya, pada bagian onBindViewHolder, data dari bookList akan dimasukkan ke dalam komponen tampilan tersebut sehingga
     informasi buku dapat tampil di layar. Dengan alur ini, setiap buku bisa ditampilkan secara terstruktur, dan tombol hapus juga dapat difungsikan untuk menghapus buku
     langsung dari daftar.

     4. Detail Activity
        <img width="960" height="540" alt="image" src="https://github.com/user-attachments/assets/51985147-b7ea-4283-bfa8-d11c395ff707" />
        Kode ini membuat sebuah class bernama BookDetailActivity yang mewarisi AppCompatActivity. Activity ini berfungsi untuk menampilkan detail sebuah buku ketika pengguna memilih salah satu item pada daftar RecyclerView.
        Di dalam method onCreate, pertama-tama dipanggil setContentView(R.layout.activity_book_detail) untuk menampilkan layout detail buku. Selanjutnya,
        beberapa komponen tampilan dihubungkan dengan variabel menggunakan findViewById, yaitu imgBook untuk gambar sampul buku, tvTitle untuk judul, tvAuthor untuk penulis, tvYear untuk tahun terbit, serta tvStory untuk ringkasan cerita.
        Setelah itu, activity ini menerima data yang dikirim dari activity sebelumnya melalui intent. Data yang diambil berupa title (judul), author (penulis), year (tahun), image (id gambar), dan story (cerita). Data ini diambil menggunakan getStringExtra untuk teks, serta getIntExtra untuk gambar.
        Kemudian, data yang sudah diterima tadi ditampilkan ke dalam komponen tampilan: imgBook.setImageResource(image) menampilkan gambar sampul, tvTitle.text = title menampilkan judul, dan tvAuthor.text = author. Bagian tvYear dan tvStory juga bisa diisi dengan data tahun terbit dan ringkasan cerita,
        meskipun di kode yang terlihat saat ini baru menampilkan judul dan penulis saja.
        Dengan alur ini, ketika pengguna memilih sebuah buku dari daftar, maka detail lengkap buku tersebut akan ditampilkan di halaman BookDetailActivity.

        5. Splash Activity
           <img width="523" height="161" alt="image" src="https://github.com/user-attachments/assets/ef09cac9-4617-4a2b-b1cd-dcdd7a91f840" />
           Kode tersebut merupakan implementasi dari SplashActivity, yaitu activity yang bertugas menampilkan layar pembuka (splash screen) sebelum pengguna diarahkan
           ke halaman utama aplikasi. Pada method onCreate, layout activity_splash dipanggil untuk menampilkan tampilan awal. Selanjutnya,
           digunakan Handler dengan Looper.getMainLooper() untuk memberikan penundaan selama 2,5 detik (2500 milidetik) menggunakan postDelayed. Setelah jeda berakhir,
           aplikasi otomatis menjalankan Intent menuju MainActivity sebagai halaman utama, lalu dipanggil finish() agar SplashActivity tertutup dan tidak bisa diakses
           kembali dengan tombol back. Dengan alur ini, splash screen hanya akan muncul sekali di awal penggunaan, memberikan kesan pertama yang menarik sebelum pengguna
           melihat daftar buku.

           6. Delete Button
              <img width="562" height="239" alt="image" src="https://github.com/user-attachments/assets/65413f3c-5416-4917-8c9b-f5e28e432142" />
              Kode di atas merupakan implementasi logika untuk menghapus data buku dari daftar ketika tombol Delete ditekan. Pertama, method setOnClickListener dipasang pada tombol hapus (btnDelete) di setiap item list.
              Saat tombol ditekan, aplikasi akan memunculkan AlertDialog sebagai dialog konfirmasi dengan judul "Hapus Buku" dan pesan "Apakah kamu yakin ingin menghapus [judul buku]?".
              Dialog tersebut memiliki dua pilihan tombol:
              Tombol "Ya": jika dipilih, maka data buku pada posisi tertentu akan dihapus dari bookList menggunakan removeAt(position).
              Setelah itu, notifyItemRemoved(position) dipanggil untuk memberi tahu adapter bahwa item pada posisi tersebut sudah dihapus,
              lalu notifyItemRangeChanged(position, bookList.size) dijalankan untuk memperbarui tampilan list agar tetap konsisten. Selanjutnya,
              muncul notifikasi singkat (Toast) bertuliskan "Buku dihapus" sebagai tanda bahwa proses penghapusan berhasil.
              Tombol "Batal": jika dipilih, dialog akan ditutup tanpa ada perubahan pada data.
              Dengan alur ini, setiap kali pengguna menekan tombol hapus, aplikasi terlebih dahulu memastikan konfirmasi dari pengguna agar tidak terjadi penghapusan
              data secara tidak sengaja, dan setelah dikonfirmasi, data akan dihapus dari daftar serta tampilan list diperbarui secara otomatis.



              - Hasil dari RecycleView // APK Buku Perpustakaan
             ![WhatsApp Image 2025-08-18 at 16 27 35_a1bc1c37](https://github.com/user-attachments/assets/373f6369-3ba0-4a24-afe2-3bc127fca510)
             ![WhatsApp Image 2025-08-18 at 16 27 35_e33dc220](https://github.com/user-attachments/assets/ae18fa93-cc11-4d3a-85c6-982d6cf635a2)
             ![WhatsApp Image 2025-08-18 at 16 27 36_a9b612ae](https://github.com/user-attachments/assets/1b0a2f2f-db11-48c2-9911-accdbe8b090b)
             ![WhatsApp Image 2025-08-18 at 16 27 36_22d8aff1](https://github.com/user-attachments/assets/1fcd969b-f0fc-4f67-b2b2-89fd667c66e7)


              - Kesimpulan
                Kesimpulan dari keseluruhan implementasi aplikasi ini adalah bahwa sistem telah dirancang untuk memberikan pengalaman pengguna yang baik melalui alur yang
                terstruktur. Aplikasi dimulai dengan SplashActivity yang berfungsi sebagai tampilan pembuka (splash screen). Komponen ini tidak hanya menambah nilai estetika
                aplikasi, tetapi juga memberi jeda singkat sebelum pengguna diarahkan ke halaman utama. Hal ini bertujuan agar transisi ke dalam aplikasi terasa lebih halus dan
                profesional.
                Selanjutnya, aplikasi menampilkan data buku dalam bentuk daftar menggunakan RecyclerView, yang dipilih karena mampu menampilkan data secara efisien meskipun
                jumlah data banyak. Setiap item buku dalam daftar ditampilkan dengan tampilan yang rapi, sehingga pengguna dapat dengan mudah melihat informasi yang tersedia.
                Untuk meningkatkan fungsionalitas dan interaktivitas, aplikasi juga dilengkapi dengan fitur hapus data. Fitur ini diterapkan dengan menambahkan tombol hapus pada
                setiap item buku. Ketika tombol ditekan, sistem akan menampilkan dialog konfirmasi terlebih dahulu. Dialog ini memberikan pilihan kepada pengguna untuk melanjutkan
                atau membatalkan penghapusan. Jika pengguna menekan “Ya”, maka data buku pada posisi yang dipilih akan dihapus dari bookList, dan perubahan langsung diperbarui pada
                RecyclerView dengan metode notifyItemRemoved serta notifyItemRangeChanged. Selain itu, ditampilkan juga Toast sebagai notifikasi singkat bahwa buku berhasil dihapus.
                Dengan adanya dialog konfirmasi ini, aplikasi tidak hanya berfokus pada fungsionalitas, tetapi juga pada keamanan data dan kenyamanan pengguna, karena sistem mencegah
                terjadinya penghapusan data secara tidak sengaja.
                Secara keseluruhan, aplikasi ini berhasil menggabungkan tampilan awal yang menarik, manajemen data buku yang efisien, serta mekanisme penghapusan yang aman.
                Hal ini menjadikan aplikasi lebih user-friendly, interaktif, dan dapat dijadikan dasar pengembangan lebih lanjut untuk sistem manajemen data yang lebih
                kompleks.




          
                
              
          

              

        


           

        


     
     
