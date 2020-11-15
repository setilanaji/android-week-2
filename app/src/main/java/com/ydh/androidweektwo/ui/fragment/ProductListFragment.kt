package com.ydh.androidweektwo.ui.fragment

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.ydh.androidweektwo.App
import com.ydh.androidweektwo.ProductShared
import com.ydh.androidweektwo.ui.adapter.ProductAdapter
import com.ydh.androidweektwo.R
import com.ydh.androidweektwo.databinding.FragmentProductListBinding
import com.ydh.androidweektwo.model.ProductModel
import com.ydh.androidweektwo.viewmodel.ProductViewModel
import com.ydh.androidweektwo.viewmodel.ProductViewModelFactory

class ProductListFragment : Fragment() {

    private lateinit var productViewModel: ProductViewModel
    private lateinit var binding : FragmentProductListBinding
    val prefs: ProductShared by lazy {
        ProductShared(App.instance)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_product_list, container, false)

        setViewModel()
        setData()

        setHasOptionsMenu(true)

        return binding.root
    }

    private fun setData(){
        productViewModel.setAllProducts()
    }

    private fun setViewModel(){
        productViewModel = ViewModelProviders.of(this, ProductViewModelFactory(this.context)).get(
            ProductViewModel::class.java)

        productViewModel.data.observe(viewLifecycleOwner,{
            val myAdapter = ProductAdapter(requireContext(), it as MutableList<ProductModel>, object : ProductAdapter.PostItemListener{
                override fun onPostClick(productModel: ProductModel) {
                    val checkout: MutableList<String> = prefs.checkOutArray.toMutableList()

                    if(checkout.isEmpty() || !prefs.isCheckedOut(productModel.id)){
                        checkout.add("${productModel.id}")
                        prefs.checkOutArray = checkout.toTypedArray()
//                        Toast.makeText(context, "Added + ${productModel.id} to cart", Toast.LENGTH_LONG).show()
                    }
//                    else{
//                        Toast.makeText(context, "You already added + ${productModel.id} to cart", Toast.LENGTH_LONG).show()

//                    }
                }
            })
            binding.rvProductsMain.run {
                layoutManager = LinearLayoutManager(context)
                adapter = myAdapter
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_product, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,
            requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }


}