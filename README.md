# android-week-2

## S.O.L.I.D
### Pengenalan
SOLID adalah sebuah singkatan dari 5 hal penting ketika hendak menerapkan OOP(Object Oriented Programming). Lima prinsip ini dikenalkan oleh Robert C. Martin (Paman Bob) dalam 2000 lembar karyanya yang berjudul Design Principle and Design Patterns.
### S- Single responsibility Principle
Maksud utama dalam prinsip ini adalah bahwa setiap class dan fungsi dalam sebuah program harus memiliki satu fungsi utama atau tanggung jawab. Jadi apabila ada sebuah perubahan dalam program makan hanya satu module, class atau method yang diubah.
### O- Open/Close Principle
Berarti sebuah entitas(class module function dll) terbuka untuk dikembangkan/diturunkan namun tertutup untuk dirubah, dalam artian entitas tersebut aman dari sengaja/ketidak sengajaan dirubah dari entitas lain.
### L- Liskov Subtitution Principle
Paman Bob pernyataan sebagai berikut “if for each object o1 of type S there is an object o2 of type T such that for all programs P defined in terms of T, the behavior of P is unchanged when o1 is substituted for o2 then S is a subtype of T”. Sederhanannya, Liskov’s substitution adalah aturan yang berlaku untuk hirarki pewarisan. Proses mendesain kelas-kelas dengan tujuan agar ketergantungan antar klien dapat disubstitusikan tanpa klien mengetahui tentang perubahan yang ada.
SubClass wajib untuk menerapkan fungsi dan properti dari SuperClass,dan perilaku yang sama dengan SuperClass-nya. 
### I- Interface Segretation Principle
Bertujuan untuk mengurangi ketergantungan kelas kepada interface kelas yang dibutuhkan. Ketergantungan ini bisa terjadi apabila kelas terpaksa mengimplementasikan fungsi-fungsi yang tidak dibutuhkan dari interface. Menurut prinsip ini, kelas interface disarankan untuk membiliki fungsi yang lebih sedikit sesuai tujuan/fungsi utama nya.
### D- Dependency Inversion Principle

## Menu
Menu dalam android bukanlah hal baru,
## Dialog
Dialog berfungsi untuk menampilkan informasi/pemberitahuan/peringatan dari aplikasi kepada pengguna.
## App Icon
Ikon dalam aplikasi menjadi salah hal kecil yang bisa jadi penting, karena ikon akan memberikan identitas dari aplikasi sebelum pengguna memutuskan untuk membuka aplikasi
## RecyclerView
RecycleView menjadi salah satu jenis View yang populer dikalangan pengguna android. View ini bertugas untnuk menampung dan menampilkan data yang sejenis secara berulang menurut urutan nya.
## Shared Prefereces
Shared Preferences adalah salah satu class yang memiliki fungsi menyimpan data baik dari pengguna maupun sistem secara permanen ke memori lokal pada handphone pengguna. Ia meyimpan data tersebut dalam bentup Map yang memiliki key dan value. Salah satu contoh penggunaan nya adalah untuk menyimpan API key untuk keperluan akses aplikasi.
## Intent
Intent digunakan untuk berpindah antar activity pada android, yang pada pengguna berarti berpindah antar layar/menu. Dalam perpindahan ini intent bisa membawa informasi/data dari aktivity sebelumnya.
## Parcels
Parcel adalah fungsi yang secara singkat mengatasi kelemahan yang dihasilkan dari metode perpindahan data oleh intent. Yang sebelumnya developer harus menuliskan satu satu data yang memiliki tipe primitive seperti String, Integer, Boolean dll, menjadi hanya satu data saja dalam bentuk object.
## Fragment
## Style
Android memiliki

