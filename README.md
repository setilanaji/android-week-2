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
"High-level modules should not depend on low-level modules. Both should depend on abstractions."
"Abstractions should not depend on details. Details should depend on abstractions."
Dengan menerapkan Dependency Inversion, modul dapat dengan mudah diubah oleh modul lain hanya dengan mengubah modul dependensi dan modul Tingkat Tinggi tidak akan terpengaruh oleh perubahan apa pun pada modul Tingkat Rendah.

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

`ListView` dan `GridViews` hanya melakukan setengah tugas untuk mencapai efisiensi memori yang sebenarnya. Mereka mendaur ulang tata letak item, tetapi tidak menyimpan referensi ke turunan tata letak, memaksa developer memanggil `findViewById()` untuk setiap turunan tata letak item yang dibuat setiap kali memanggil `getView()`.

Semua panggilan ini dapat menjadi intensif prosesor, terutama untuk tata letak yang rumit. Selain itu, situasi ini dapat menyebabkan scroll ListView menjadi tersentak atau tidak responsif saat mencoba mengambil referensi tampilan.

Android awalnya memberikan solusi untuk masalah ini di situs Developer Android dengan smooth srolling melalui View Holder pettern.

Dengan pola ini, kelas menjadi referensi dalam memori ke semua tampilan yang diperlukan untuk mengisi tata letak. Referensi dapat di set satu kali dan di gunakan kembali, mengatasi klik performa yang datang dengan memanggil `findViewById()` berulang kali.

Untuk memberikan tampilan baru, `RecyclerView` membuat objek `ViewHolder` baru untuk me extend layout dan menyimpan referensi tersebut, atau mendaur ulang salah satu dari stack yang ada.

`RecyclerView` datang dengan animasi default yang tidak perlu developer buat atau tambahkan sendiri.

`RecyclerView` memiliki `LayoutManager`. Objek ini memposisikan item `RecyclerView` dan memberi tahu kapan harus mendaur ulang item yang telah dialihkan ke luar layar. `ListView`digunakan untuk melakukan pekerjaan ini sendirian. `RecyclerView` telah memecah fungsi ini untuk memungkinkan berbagai jenis layout: Vertikal, horizontal, kisi (grid), terhuyung-huyung (staggered), atau custom dari develeper sendiri.

Layout manager memiliki 3 pilihan:
- `LinearLayoutManager` memosisikan items menjadi mirip seperti `ListView` biasa
- `GridLayoutManager` memosisikan items dalam bentuk kisi sama seperti sebuah `GridView`
- `StaggeredGridLayoutManager` memosisikan tems dalam bentuk staggered grid.

berikut contoh cara penulisan `RecyclerView` dalam file layout xml
```xml
<android.support.v7.widget.RecyclerView
  android:id="@+id/recyclerView"
  android:layout_width="match_parent"
  android:layout_height="match_parent"
  android:scrollbars="vertical"/>
```
## Shared Prefereces
Shared Preferences adalah salah satu class yang memiliki fungsi menyimpan data sederhana berupa data yang bertipe primitif (seperti `Float`, `Int`, `Long`, `String` dan `Boolean`) baik dari pengguna maupun sistem secara permanen ke memori lokal pada handphone pengguna. Ia meyimpan data tersebut dalam bentup Map yang memiliki key dan value. Salah satu contoh penggunaan nya adalah untuk menyimpan API key untuk keperluan akses aplikasi.

Beberapa metode penting untuk SharedPreferences:
- `getSharedPreferences (String, int)` metode digunakan untuk mengambil sebuah instance dari `SharedPreferences`. Di sini `String` adalah nama file `SharedPreferences` dan `int` adalah Konteks yang diteruskan.
- `SharedPreferences.Editor ()` digunakan untuk mengedit nilai di `SharedPreferences`.
- Kita dapat memanggil `commit()` atau `apply()` untuk menyimpan nilai dalam file `SharedPreferences`. `commit()` menyimpan nilai dengan segera sedangkan `apply()` menyimpan nilai secara asinkron.

cara me set values pada instansi SharePreferences:
```kotlin
val sharedPreference =  getSharedPreferences("PREFERENCE_NAME",Context.MODE_PRIVATE)
var editor = sharedPreference.edit()
editor.putString("username","Koko")
editor.putLong("l",100L)
editor.commit()
```
untuk mengambil values:
```kotlin
sharedPreference.getString("username","defaultName")
sharedPreference.getLong("l",1L)
```
## Intent
Intent digunakan untuk berpindah antar activity pada android, yang pada pengguna berarti berpindah antar layar/menu. Dalam perpindahan ini intent bisa membawa informasi/data dari aktivity sebelumnya.
## Parcels
Parcel adalah fungsi yang secara singkat mengatasi kelemahan yang dihasilkan dari metode perpindahan data oleh intent. Yang sebelumnya developer harus menuliskan satu satu data yang memiliki tipe primitive seperti String, Integer, Boolean dll, menjadi hanya satu data saja dalam bentuk object.

Pada dasarnya Parcelable adalah komponen Android SDK, Antarmuka yang mirip dengan JAVA Serializable. Ini adalah cara yang disarankan Android untuk meneruskan struktur data khusus yang dibuat di antara berbagai komponen dalam aplikasi, karena Parcelable diproses relatif cepat dibandingkan dengan serialisasi JAVA standar, karena developer harus menjelaskan tentang proses serialisasi secara eksplisit daripada menggunakan refleksi untuk menyimpulkannya.

Menjadikan kelas menjadi Parcelable cukup mentulitkan, tidak peduli Kotlin atau JAVA bahasa apa pun yang digunakan. Jadi, para developer mulai membuat plugin dan libraty Android Studio yang berbeda untuk membuat hidup developer lebih mudah.

Ada 3 cara untuk membuat kelas menjadi Parcelable:
- Menerapkan antarmuka Parcelable dan menentukan sendiri serialisasi (Cara tradisional)
- Menggunakan plugin Android Studio, seperti generator kode Android Parcelable
- Menggunakan library berbasis anotasi, seperti Parceler

contoh sebuah Data class Item seperti berikut:
```kotlin
data class Item(
    val title: String,
    val details: String,
    val price: Double,
    val category: String
)
```
Parcelable: cara tradisional
```kotlin
class Item(
    val title: String,
    val details: String,
    val price: Double,
    val category: String) : Parcelable {

    companion object {
        @JvmField
        val CREATOR = object : Parcelable.Creator<Item> {
        override fun createFromParcel(parcel: Parcel) = Item(parcel)
        override fun newArray(size: Int) = arrayOfNulls<Item>(size)
        }
    }

    private constructor(parcel: Parcel) : this(
        title = parcel.readString(),
        details = parcel.readString(),
        price = parcel.readDouble(),
        category = parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(details)
        parcel.writeDouble(price)
        parcel.writeString(category)
    }

    override fun describeContents() = 0
}
```
Parcelable: menggunakan anotasi
```kotlin
@Parcelize
data class Item(
    var imageId: Int,
    var title: String,
    var price: Double,
    var category: String
) : Parcelable
```
cara mengirimkan data:
```kotlin
val intent = Intent(this, AnotherActivity::class.java)
intent.putExtra("extra_item", item)
```
cara menerima data:
```kotlin
val item = intent.getParcelableExtra("extra_item")
```
Yang perlu dilakukan adalah:
- menggunakan versi terakhir Kotlin
- menggunakan @Parcelize di atas Data Class/Model
- menggunakan versi terakhir Kotlin Android Extension pada modul App seperti berikut:
```text
apply plugin: 'com.android.application'
apply plugin: 'kotlin-android'
apply plugin: 'kotlin-android-extensions'

android {
    ... ... ...
    
    // Add for using latest experimental build of Android Extensions
    androidExtensions {
        experimental = true
    }
}

dependencies {
    ... ... ...
}
```
## Fragment
Dalam dokumentasi android, Fragment mewakili perilaku atau bagian dari antarmuka pengguna dalam FragmentActivity. Developer bisa mengombinasikan beberapa fragmen dalam satu aktivitas untuk membangun UI multipanel dan menggunakan kembali sebuah fragmen dalam beberapa aktivitas. Developer bisa menganggap fragmen sebagai bagian modular dari aktivitas, yang memiliki daur hidup sendiri, menerima masukan sendiri, dan yang bisa ditambahkan atau dihapus saat aktivitas berjalan (semacam "subaktivitas" yang bisa digunakan kembali dalam aktivitas berbeda)

Beberapa point penting dalam fragment yang perlu diketahui:
- Fragment dibuat dengan kombinasi file XML Layout dan kelas seperti Activity.
- Fragment memiliki layout, perilaku, dan life-cyclenya sendiri.
- Fragment dapat di “add” atau “remove” dalam suatu activity saat activity dalam keadaan running.
- Fragment berdiri dan bergantung pada suatu activity dan life-cyclenya dipengaruhi oleh lifecycle activity itu sendiri (Ketika activity pause, fragment juga pause. Ketika activity destroyed, semua fragment akan destroyed)
- Fragment dapat berperilaku seperti activity dalam hal stack. Yaitu dengan penggunaan back stack pada fragment. Fragment baru akan ditambahkan ke stack. Jika kita menekan tombol back, maka akan kembali ke stack fragment yang ditambahkan sebelumnya.

Ada batasan di mana hanya dapat menampilkan satu activity saja pada layar. Batasan tersebut dipenuhi dengan adanya fragment. Dengan fragment developer dapat membuat lebih dari satu tampilan dengan layout, event, dan lifecycle yang di handle oleh setiap fragment yang berbeda pada satu activity

Untuk menambahkan dan menggunakan fragment developer perlu membuat file XML layout dan kelas yang meng-extend kelas Fragment , sama seperti saat membuat dan menggunakan activity.
Ada 3 method yang biasanya di-implementasi/override yaitu `onCreate()`, `onCreateView()`, dan `onPause()`. (Minimal harus ada onCreateView untuk meng-inflate layout untuk menentukan tampilan dari fragmentnya)

Ada dua cara untuk menggunakan atau meng-embed fragment pada activity: statis dan dinamis. Statis yaitu dengan cara menggunakan tag fragment secara langsung pada file layout Activity. Dinamis yaitu dengan cara menggunakan FragmentManager dan FragmentTransaction dengan menggunakan layout yang ditambahkan pada layout XML activity sebagai wadah atau container untuk menempel atau meng-embed fragment.

## Style
Style menentukan format dan tampilan UI. STyle dapat diterapkan ke Tampilan individu (dari dalam file layout) atau ke seluruh Aktivitas atau aplikasi (dari dalam file manifes).

Style didefinisikan dalam XML resource yang terpisah dari XML yang menetapkan layout. File XML ini berada di bawah direktori res / values ​​/ project dan akan memiliki <resources> sebagai node root yang wajib untuk file style. Nama file XML bisa berubah-ubah, tetapi harus menggunakan ekstensi .xml.

```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
   <style name="CustomFontStyle">
      <item name="android:layout_width">fill_parent</item>
      <item name="android:layout_height">wrap_content</item>
      <item name="android:capitalize">characters</item>
      <item name="android:typeface">monospace</item>
      <item name="android:textSize">12pt</item>
      <item name="android:textColor">#00FF00</item>/> 
   </style>
</resources>
```
Setelah style sudah ditentukan, developer dapat menggunakannya dalam file layout XML menggunakan atribut gaya seperti contoh berikut
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
   android:layout_width="fill_parent"
   android:layout_height="fill_parent"
   android:orientation="vertical" >

   <TextView
      android:id="@+id/text_id"
      style="@style/CustomFontStyle"
      android:text="@string/hello_world" />

</LinearLayout>
```
## ViewModel
Kelas ViewModel dirancang untuk menyimpan dan mengelola data terkait UI dengan tetap memperhaikan siklus hidup. Ini memungkinkan data bertahan dari perubahan konfigurasi seperti rotasi layar.

Secara umum, kelas ViewModel dibuat untuk setiap layar dalam aplikasi. Kelas ViewModel ini akan menampung semua data yang terkait dengan layar dan memiliki getter dan setter untuk data yang disimpan. Ini memisahkan kode untuk menampilkan UI, yang diterapkan di Aktivitas dan Fragmen, dari data, yang sekarang ada di ViewModel.

Berikut contoh pen inisialisasian ViewModel
```kotlin
class ScoreViewModel: ViewModel() {
   // Tracks the score for Team A
   var scoreTeamA = 0;

   // Tracks the score for Team B
   var scoreTeamB = 0;
}
```
Pengontrol UI (alias Activity atau Fragment) perlu tahu tentang ViewModel yang dibuat. Ini agar pengontrol UI dapat menampilkan data dan mengupdate data saat terjadi interaksi pada UI, seperti menekan sebuah tombol untuk menambah angka.

Namun, ViewModels tidak boleh memiliki referensi ke Aktivitas, Fragmen, atau Konteks. Selain itu, ViewModels tidak boleh berisi elemen yang berisi referensi ke pengontrol UI, seperti Views, karena ini akan membuat referensi tidak langsung ke Konteks.

Alasan tidak boleh menyimpan objek ini adalah karena ViewModels hidup lebih lama dari instance pengontrol UI - jika sebuah Aktivitas dirotasi tiga kali, tiga instance Activity yang berbeda akan terbuat, tetapi hanya memiliki satu ViewModel.

Berikut cara membuat variabel dari ViewModel pada UI controller. Di panggil pada `OnCreate` :
```kotlin
ViewModelProviders.of(<UI controller>).get(<Nama ViewModel>.class)
```

Ada satu pengecualian untuk aturan "tidak ada konteks di ViewModels". Terkadang dalam suatu kasus mungkin memerlukan konteks Aplikasi (sebagai lawan dari konteks Aktivitas) untuk digunakan dengan hal-hal seperti layanan sistem. Menyimpan konteks Aplikasi dalam ViewModel tidak apa-apa karena konteks Aplikasi terkait dengan siklus hidup Aplikasi. Ini berbeda dari konteks Aktivitas, yang terkait dengan siklus hidup Aktivitas. Faktanya, jika memang membutuhkan konteks Aplikasi, Maka harus menggunakan AndroidViewModel yang merupakan ViewModel yang menyertakan referensi Aplikasi.
