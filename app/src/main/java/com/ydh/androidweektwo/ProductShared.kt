package com.ydh.androidweektwo

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.google.gson.Gson
import com.ydh.androidweektwo.model.ProductModel

class ProductShared(private val context: Context){
    companion object{
        const val SHARED_NAME = "com.ydh.androidweektwo"

        const val FAVORITE_KEY = "FAVORITE_KEY"
        const val CHECKOUT_KEY = "CHECKOUT_KEY"

    }

    private val pref: SharedPreferences by lazy{
        context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE)
    }

    var favoriteArray: Array<String>
        get() = pref.getStringSet(FAVORITE_KEY, emptySet())?.toTypedArray()?: emptyArray()
        set(value) = pref.edit { putStringSet(FAVORITE_KEY, value.toSet()) }

    var checkOutArray: Array<String>
        get() = pref.getStringSet(CHECKOUT_KEY, emptySet())?.toTypedArray()?: emptyArray()
        set(value) = pref.edit{ putStringSet(CHECKOUT_KEY, value.toSet())}

    fun isCheckedOut(id: Int): Boolean{
        val checkout: MutableList<String> = this.checkOutArray.toMutableList()
        var saved = false
        checkout.forEach { c ->
            if (c == "$id"){
                saved = true
            }
        }
        return saved
    }

    fun isFav(id: Int?): Boolean{
        val fav: MutableList<String> = this.favoriteArray.toMutableList()
        var saved = false
        fav.forEach { c ->
            if (c == "$id"){
                saved = true
            }
        }
        return saved
    }

    fun deleteItem(id: Int){
        val checkout: MutableList<String> = this.checkOutArray.toMutableList()
        checkout.remove("$id")
        checkOutArray = checkout.toTypedArray()
    }

    fun deleteFav(id: Int){
        val fav: MutableList<String> = this.favoriteArray.toMutableList()
        fav.remove("$id")
        favoriteArray = fav.toTypedArray()
    }


}