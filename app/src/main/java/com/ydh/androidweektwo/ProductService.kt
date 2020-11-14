package com.ydh.androidweektwo

import com.ydh.androidweektwo.model.ProductModel
import retrofit2.Call
import retrofit2.http.GET

interface ProductService {

    @GET("products")
    fun getProducts(): Call<List<ProductModel>>
}