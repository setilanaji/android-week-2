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
import com.ydh.androidweektwo.R
import com.ydh.androidweektwo.databinding.ItemProductBinding
import com.ydh.androidweektwo.model.ProductModel


class ProductAdapter(
    private val context: Context,
    private val items: MutableList<ProductModel>,
    private val  itemListener: ProductAdapter.PostItemListener
) : RecyclerView.Adapter<ProductAdapter.UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

        val inflater = LayoutInflater.from(context)
        val binding: ItemProductBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.item_product, parent, false
        )
        return UserViewHolder(binding, this.itemListener)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
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
    }

    class UserViewHolder(
        var itemProductBinding: ItemProductBinding,
        var itemListener: ProductAdapter.PostItemListener
    ) : RecyclerView.ViewHolder(itemProductBinding.root), View.OnClickListener {
        private var binding: ItemProductBinding? = null

        init {
            this.binding = itemProductBinding
            binding?.buttonAdd?.setOnClickListener (this)
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