package com.ydh.androidweektwo.ui.fragment

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.ydh.androidweektwo.R
import com.ydh.androidweektwo.databinding.FragmentFavoriteBinding
import com.ydh.androidweektwo.model.ProductModel
import com.ydh.androidweektwo.ui.adapter.CartAdapter
import com.ydh.androidweektwo.ui.adapter.ProductAdapter
import com.ydh.androidweektwo.viewmodel.CartViewModel
import com.ydh.androidweektwo.viewmodel.CartViewModelFactory
import com.ydh.androidweektwo.viewmodel.FavoriteViewModel
import com.ydh.androidweektwo.viewmodel.FavoriteViewModelFactory


class FavoriteFragment : Fragment() {
    lateinit var binding: FragmentFavoriteBinding
    lateinit var favViewModel: FavoriteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorite,container, false)
        setViewModel()
        setData()

        return binding.root

    }

    private fun setData(){
        favViewModel.setAllFavItem()
    }

    private fun setViewModel(){
        favViewModel = ViewModelProviders.of(this, FavoriteViewModelFactory(this.context)).get(
            FavoriteViewModel::class.java)

        favViewModel.data.observe(viewLifecycleOwner,{ it ->
            val myAdapter = ProductAdapter(requireContext(), it as MutableList<ProductModel>, object : ProductAdapter.PostItemListener{
                override fun onPostClick(productModel: ProductModel) {
                    favViewModel.deleteCartItem(productModel)
                }

                override fun onFavClick(productModel: ProductModel, checked: Boolean) {
                    favViewModel.setFav(productModel, checked)
                }

                override fun onImgClick(uri: String) {
                    imgOnClick(uri)
                }
            })
            binding.rvFavoriteMain.run {
                layoutManager = LinearLayoutManager(context)
                adapter = myAdapter
            }
        })

    }
    fun imgOnClick(uri:String){
        val builder = Dialog(requireContext())
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE)
        builder.window?.setBackgroundDrawable(
            ColorDrawable(Color.TRANSPARENT)
        )
        builder.setOnCancelListener {
            it.dismiss()
        }
        val imageView = ImageView(requireContext())
        Glide.with(requireContext())
            .load(uri)
            .into(imageView)

        builder.addContentView(
            imageView, RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        )
        builder.show()

    }

}