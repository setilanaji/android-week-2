package com.ydh.androidweektwo.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ydh.androidweektwo.App
import com.ydh.androidweektwo.ProductShared
import com.ydh.androidweektwo.R
import com.ydh.androidweektwo.databinding.ItemProductBinding
import com.ydh.androidweektwo.model.ProductModel


class ProductAdapter(
    private val context: Context,
    private val items: MutableList<ProductModel>,
    private val  itemListener: ProductAdapter.PostItemListener
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(context)
        val binding: ItemProductBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.item_product, parent, false
        )
        return ViewHolder(binding, this.itemListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemProductBinding.product = getItem(position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

     private fun getItem(position: Int): ProductModel {
        return items[position]
    }

    interface PostItemListener {
        fun onPostClick(productModel: ProductModel)
        fun onFavClick(productModel: ProductModel, checked: Boolean)
    }

    class ViewHolder(
        var itemProductBinding: ItemProductBinding,
        var itemListener: ProductAdapter.PostItemListener
    ) : RecyclerView.ViewHolder(itemProductBinding.root), View.OnClickListener {
        private var binding: ItemProductBinding? = null
//        private val prefs: ProductShared by lazy {
//            ProductShared(App.instance)
//        }
        init {
            this.binding = itemProductBinding
            binding?.buttonAdd?.setOnClickListener (this)
//            binding?.itemProductItemFav?.isChecked = false
            binding?.itemProductItemFav?.setOnClickListener {
                val product = binding?.product
                var checked = false
                if (binding!!.itemProductItemFav.isChecked){
                    checked = true
                    println("check TRUE")
                }
                if (product != null) {
                    this.itemListener.onFavClick(product, checked)
                }
            }
        }

        companion object {

            @JvmStatic
            @BindingAdapter("productImage")
            fun loadImage(view: ImageView, productImage: String) {
                Glide.with(view.context)
                    .load(productImage)
                    .circleCrop()
                    .into(view)
            }


        }

         override fun onClick(v: View?) {
             val product = binding?.product
             if (product != null) {
                 this.itemListener.onPostClick(product)
             }
         }

     }


}