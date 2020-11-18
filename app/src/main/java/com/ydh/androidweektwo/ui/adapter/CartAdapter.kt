package com.ydh.androidweektwo.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ydh.androidweektwo.R
import com.ydh.androidweektwo.databinding.ItemCartBinding
import com.ydh.androidweektwo.model.ProductModel


class CartAdapter(
    private val context: Context,
    private val items: MutableList<ProductModel>,
    private val  itemListener: CartAdapter.PostItemListener
) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(context)
        val binding: ItemCartBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.item_cart, parent, false
        )
        return ViewHolder(binding, this.itemListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemCartBinding.product = getItem(position)
    }

    override fun getItemCount(): Int {
//        println(items.size)
        return items.size
    }

    private fun getItem(position: Int): ProductModel {
        return items[position]
    }

    interface PostItemListener {
        fun onPostClick(productModel: ProductModel)
    }

    class ViewHolder(
        var itemCartBinding: ItemCartBinding,
        var itemListener: CartAdapter.PostItemListener
    ) : RecyclerView.ViewHolder(itemCartBinding.root), View.OnClickListener {
        private var binding: ItemCartBinding? = null

        init {
            this.binding = itemCartBinding
            binding?.ivCartItemDelete?.setOnClickListener(this)
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
            @JvmStatic
            @BindingAdapter("productPrice")
            fun productPrice(view: TextView, price: Double){
                view.text = price.toString()
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