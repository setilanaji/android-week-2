package com.ydh.androidweektwo.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ydh.androidweektwo.ApiClient
import com.ydh.androidweektwo.model.ProductModel
import retrofit2.Call
import retrofit2.Response

class CartViewModel(context: Context?): ViewModel(){
    private val _data: MutableLiveData<List<ProductModel>> by lazy {
        MutableLiveData<List<ProductModel>>()
    }

    val data : LiveData<List<ProductModel>>
        get() = _data

    fun setAllCartItem(list: List<String>){
        val mutableList = arrayListOf<ProductModel>()
        list.forEach {
            ApiClient.apiService.getProduct(it.toInt()).enqueue(object :
                retrofit2.Callback<ProductModel> {
                override fun onResponse(call: Call<ProductModel>, response: Response<ProductModel>) {
                    val productResponse = response.body()
                    mutableList.add(productResponse!!)
                    _data.value = mutableList

//                    response.body()?.apply { it1 -> mutableList.add(it1) }
                    Log.d("TAG", "Response = ${mutableList.toString()}");
                }

                override fun onFailure(call: Call<ProductModel>, t: Throwable) {
                    Log.d("TAG", "Response = $t");
                }

            }
            )
        }
//        Log.d("TAG", "isi list = ${mutableList.toString()}");

    }
}