package com.ydh.androidweektwo

import com.ydh.androidweektwo.model.ProductModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService {

    @GET("products")
    fun getProducts(): Call<List<ProductModel>>

    @GET("products/{id}")
    fun getProduct(@Path("id") id: Int): Call<ProductModel>
}