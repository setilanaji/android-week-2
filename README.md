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
Menu dalam android bukanlah hal baru, berisi item/pilihan untuuk mendeskripsikan sebuah tindakan. Menu dibagi menjadi tiga tipe dasar, yaitu option menu, pop up menu, dan dan konteks menu.
```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:id="@+id/new_game"
          android:icon="@drawable/ic_new_game"
          android:title="@string/new_game"
          android:showAsAction="ifRoom"/>
    <item android:id="@+id/help"
          android:icon="@drawable/ic_help"
          android:title="@string/help" />
</menu>
 ```
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
## ViewModel
Kelas ViewModel dirancang untuk menyimpan dan mengelola data terkait UI dengan tetap memperhaikan siklus hidup. Ini memungkinkan data bertahan dari perubahan konfigurasi seperti rotasi layar.

Secara umum, kelas ViewModel dibuat untuk setiap layar dalam aplikasi. Kelas ViewModel ini akan menampung semua data yang terkait dengan layar dan memiliki getter dan setter untuk data yang disimpan. Ini memisahkan kode untuk menampilkan UI, yang diterapkan di Aktivitas dan Fragmen, dari data, yang sekarang ada di ViewModel.
Berikut contoh pen inisialisasian ViewModel
```kotlin
public class ScoreViewModel extends ViewModel {
   // Tracks the score for Team A
   public int scoreTeamA = 0;

   // Tracks the score for Team B
   public int scoreTeamB = 0;
}
```
Pengontrol UI (alias Activity atau Fragment) perlu tahu tentang ViewModel yang dibuat. Ini agar pengontrol UI dapat menampilkan data dan mengupdate data saat terjadi interaksi pada UI, seperti menekan sebuah tombol untuk menambah angka.

Namun, ViewModels tidak boleh memiliki referensi ke Aktivitas, Fragmen, atau Konteks. Selain itu, ViewModels tidak boleh berisi elemen yang berisi referensi ke pengontrol UI, seperti Views, karena ini akan membuat referensi tidak langsung ke Konteks.

Alasan tidak boleh menyimpan objek ini adalah karena ViewModels hidup lebih lama dari instance pengontrol UI - jika sebuah Aktivitas dirotasi tiga kali, tiga instance Activity yang berbeda akan terbuat, tetapi hanya memiliki satu ViewModel.

Berikut cara membuat variabel dari ViewModel pada UI controller. Di panggil pada OnCreate :
```kotlin
ViewModelProviders.of(<UI controller>).get(<Nama ViewModel>.class)
```

Ada satu pengecualian untuk aturan "tidak ada konteks di ViewModels". Terkadang dalam suatu kasus mungkin memerlukan konteks Aplikasi (sebagai lawan dari konteks Aktivitas) untuk digunakan dengan hal-hal seperti layanan sistem. Menyimpan konteks Aplikasi dalam ViewModel tidak apa-apa karena konteks Aplikasi terkait dengan siklus hidup Aplikasi. Ini berbeda dari konteks Aktivitas, yang terkait dengan siklus hidup Aktivitas. Faktanya, jika memang membutuhkan konteks Aplikasi, Maka harus menggunakan AndroidViewModel yang merupakan ViewModel yang menyertakan referensi Aplikasi.
