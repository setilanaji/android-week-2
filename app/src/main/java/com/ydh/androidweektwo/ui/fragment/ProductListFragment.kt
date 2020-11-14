package com.ydh.androidweektwo.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.ydh.androidweektwo.ProductAdapter
import com.ydh.androidweektwo.R
import com.ydh.androidweektwo.databinding.FragmentProductListBinding
import com.ydh.androidweektwo.model.ProductModel
import com.ydh.androidweektwo.viewmodel.ProductViewModel
import com.ydh.androidweektwo.viewmodel.ProductViewModelFactory

class ProductListFragment : Fragment() {

    private lateinit var productViewModel: ProductViewModel
    private lateinit var binding : FragmentProductListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_product_list, container, false)

        setViewModel()
        setData()
        return binding.root
    }

    private fun setData(){
        productViewModel.setAllUser()
    }

    private fun setViewModel(){
        productViewModel = ViewModelProviders.of(this, ProductViewModelFactory(this.context)).get(
            ProductViewModel::class.java)

        productViewModel.data.observe(viewLifecycleOwner,{
            val myAdapter = ProductAdapter(requireContext(), it as MutableList<ProductModel>)
            binding.rvProductsMain.run {

                layoutManager = LinearLayoutManager(context)
                adapter = myAdapter
            }
        })
    }

}