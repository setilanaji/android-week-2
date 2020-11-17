package com.ydh.androidweektwo.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FavoriteViewModelFactory(private val context: Context?) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FavoriteViewModel(context!!) as T
    }

}