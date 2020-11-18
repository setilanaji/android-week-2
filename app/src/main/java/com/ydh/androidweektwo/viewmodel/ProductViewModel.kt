package com.ydh.androidweektwo.viewmodel

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ydh.androidweektwo.ApiClient
import com.ydh.androidweektwo.App
import com.ydh.androidweektwo.ProductShared
import com.ydh.androidweektwo.model.ProductModel
import retrofit2.Call
import retrofit2.Response

class ProductViewModel(private val context: Context): ViewModel() {

    private val prefs: ProductShared by lazy {
        ProductShared(App.instance)
    }
    private val _data: MutableLiveData<List<ProductModel>> by lazy {
        MutableLiveData<List<ProductModel>>()
    }

    val data : LiveData<List<ProductModel>>
        get() = _data

    private val _count: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>(0)
    }

    val count : LiveData<Int>
        get() = _count

    fun setAllProducts(){
        ApiClient.apiService.getProducts().enqueue(object :
            retrofit2.Callback<List<ProductModel>> {
            override fun onResponse(call: Call<List<ProductModel>>, response: Response<List<ProductModel>>) {
                val productResponse = response.body()

                productResponse?.forEach {
                    it.fav = prefs.isFav(it.id)
                }

                _data.postValue(productResponse)
            }

            override fun onFailure(call: Call<List<ProductModel>>, t: Throwable) {
                Log.d("TAG", "Response = $t");
            }

        })
    }

    fun setCount(): Int{
        _count.value = prefs.countCart
        return prefs.countCart
    }

    fun setFav(productModel: ProductModel, checked: Boolean){
        if (checked){
            val fav: MutableList<String> = prefs.favoriteArray.toMutableList()
            if(fav.isEmpty() || !prefs.isFav(productModel.id)){
                fav.add("${productModel.id}")
                prefs.favoriteArray = fav.toTypedArray()
                Toast.makeText(context, "${productModel.title} is added to fav", Toast.LENGTH_LONG).show()
            }
        }else{
            prefs.deleteFav(productModel.id)
            Toast.makeText(context, "${productModel.title} is deleted from fav", Toast.LENGTH_LONG).show()

        }
    }
    fun updateBadgeCount(){
        _count.postValue(if (_count.value == null) 1 else _count.value!!.plus(1))
        prefs.countCart += 1
    }


}