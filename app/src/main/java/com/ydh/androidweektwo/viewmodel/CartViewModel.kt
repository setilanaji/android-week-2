package com.ydh.androidweektwo.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ydh.androidweektwo.ApiClient
import com.ydh.androidweektwo.App
import com.ydh.androidweektwo.ProductShared
import com.ydh.androidweektwo.model.ProductModel
import retrofit2.Call
import retrofit2.Response

class CartViewModel(context: Context?) : ViewModel() {

    val mutableList = arrayListOf<ProductModel>()

    private val prefs: ProductShared by lazy {
        ProductShared(App.instance)
    }
    private val _data: MutableLiveData<List<ProductModel>> by lazy {
        MutableLiveData<List<ProductModel>>()
    }

    val data: LiveData<List<ProductModel>>
        get() = _data

    fun setAllCartItem() {
        val checkout: MutableList<String> = prefs.checkOutArray.toMutableList()
        checkout.forEach {
            ApiClient.apiService.getProduct(it.toInt()).enqueue(object :
                retrofit2.Callback<ProductModel> {
                override fun onResponse(
                    call: Call<ProductModel>,
                    response: Response<ProductModel>
                ) {
                    val productResponse = response.body()
                    mutableList.add(productResponse!!)
                    _data.value = mutableList
                    Log.d("TAG", "Response = ${mutableList.toString()}");
                }

                override fun onFailure(call: Call<ProductModel>, t: Throwable) {
                    Log.d("TAG", "Response = $t");
                }

            }
            )
        }

    }

    fun deleteCartItem(item: ProductModel) {
        prefs.deleteItem(item.id)
        mutableList.remove(item)
        _data.value = mutableList
    }

    fun getTotal(): Double{
        return mutableList.sumByDouble {
            it.price
        }
    }




}