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

class ProductViewModel(private val context: Context): ViewModel() {
    private val _data: MutableLiveData<List<ProductModel>> by lazy {
        MutableLiveData<List<ProductModel>>()
    }

    val data : LiveData<List<ProductModel>>
        get() = _data

    private val _response = MutableLiveData<String>()
    val response : LiveData<String>
        get() = _response


    fun setAllUser(){
        ApiClient.apiService.getProducts().enqueue(object :
            retrofit2.Callback<List<ProductModel>> {
            override fun onResponse(call: Call<List<ProductModel>>, response: Response<List<ProductModel>>) {
                val productResponse = response.body()
                _data.postValue(productResponse)
                Log.d("TAG", "Response = $_data");
            }

            override fun onFailure(call: Call<List<ProductModel>>, t: Throwable) {
                Log.d("TAG", "Response = $t");
            }

        }

        )

    }

}