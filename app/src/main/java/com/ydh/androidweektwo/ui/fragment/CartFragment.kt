package com.ydh.androidweektwo.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.ydh.androidweektwo.App
import com.ydh.androidweektwo.ProductShared
import com.ydh.androidweektwo.R
import com.ydh.androidweektwo.databinding.FragmentCartBinding
import com.ydh.androidweektwo.databinding.FragmentProductListBinding
import com.ydh.androidweektwo.model.ProductModel
import com.ydh.androidweektwo.ui.adapter.CartAdapter
import com.ydh.androidweektwo.ui.adapter.ProductAdapter
import com.ydh.androidweektwo.viewmodel.CartViewModel
import com.ydh.androidweektwo.viewmodel.CartViewModelFactory
import com.ydh.androidweektwo.viewmodel.ProductViewModel
import com.ydh.androidweektwo.viewmodel.ProductViewModelFactory

class CartFragment : Fragment() {

    private lateinit var cartViewModel: CartViewModel
    private lateinit var binding : FragmentCartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentCartBinding>(inflater,R.layout.fragment_cart, container, false)
        setViewModel()
        setData()

        return binding.root
    }

    private fun setData(){
        cartViewModel.setAllCartItem()
    }

    private fun setViewModel(){
        cartViewModel = ViewModelProviders.of(this, CartViewModelFactory(this.context)).get(
            CartViewModel::class.java)

        cartViewModel.data.observe(viewLifecycleOwner,{ it ->
            val myAdapter = CartAdapter(requireContext(), it as MutableList<ProductModel>, object : CartAdapter.PostItemListener{
                override fun onPostClick(productModel: ProductModel) {
                    cartViewModel.deleteCartItem(productModel)
                }
            })
            binding.rvProductCart.run {
                layoutManager = LinearLayoutManager(context)
                adapter = myAdapter
            }
        })

    }




}