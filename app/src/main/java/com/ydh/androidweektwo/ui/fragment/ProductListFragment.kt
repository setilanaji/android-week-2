package com.ydh.androidweektwo.ui.fragment

import android.app.Dialog
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.view.ViewGroup
import android.widget.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.ydh.androidweektwo.App
import com.ydh.androidweektwo.ProductShared
import com.ydh.androidweektwo.R
import com.ydh.androidweektwo.databinding.FragmentProductListBinding
import com.ydh.androidweektwo.model.ProductModel
import com.ydh.androidweektwo.ui.adapter.ProductAdapter
import com.ydh.androidweektwo.viewmodel.ProductViewModel
import com.ydh.androidweektwo.viewmodel.ProductViewModelFactory


class ProductListFragment : Fragment() {

    private lateinit var productViewModel: ProductViewModel
    private lateinit var binding : FragmentProductListBinding
    private lateinit var redCircle: FrameLayout
    private lateinit var countText: TextView
    private lateinit var myMenu: Menu
    lateinit var item: MenuItem
    var cartCount = 0

    val prefs: ProductShared by lazy {
        ProductShared(App.instance)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = DataBindingUtil.inflate(
           inflater,
           R.layout.fragment_product_list, container, false
       )

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
            ProductViewModel::class.java
        )

        productViewModel.data.observe(viewLifecycleOwner, {
            val myAdapter = ProductAdapter(
                requireContext(),
                it as MutableList<ProductModel>,
                object : ProductAdapter.PostItemListener {
                    override fun onPostClick(productModel: ProductModel) {
                        val checkout: MutableList<String> = prefs.checkOutArray.toMutableList()

                        if (checkout.isEmpty() || !prefs.isCheckedOut(productModel.id)) {
                            checkout.add("${productModel.id}")
                            prefs.checkOutArray = checkout.toTypedArray()
                            Toast.makeText(
                                context,
                                "${productModel.title} is added to cart",
                                Toast.LENGTH_LONG
                            ).show()
                            cartCount += 1
                            updateBadgeCount()
                        } else {
                            Toast.makeText(
                                context,
                                "You already added this item to cart",
                                Toast.LENGTH_LONG
                            ).show()

                        }
                    }

                    override fun onFavClick(productModel: ProductModel, checked: Boolean) {
                        productViewModel.setFav(productModel, checked)

                    }

                    override fun onImgClick(uri: String) {
                        Toast.makeText(
                            context,
                            "Tapped",
                            Toast.LENGTH_LONG
                        ).show()
                        imgOnClick(uri)
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
        return NavigationUI.onNavDestinationSelected(
            item,
            requireView().findNavController()
        )
                || super.onOptionsItemSelected(item)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        this.myMenu = menu
        item = myMenu.findItem(R.id.cartFragment)
        val root = item.actionView as? FrameLayout
        if (root != null) {
            redCircle = root.findViewById(R.id.view_alert_red_circle) as FrameLayout
        }
        if (root != null) {
            countText = root.findViewById(R.id.view_alert_count_textview) as TextView
        }
        root?.setOnClickListener { onOptionsItemSelected(item) }
        return super.onPrepareOptionsMenu(menu)
    }

    fun updateBadgeCount(){
        if (cartCount > 0 ){
            countText.text = cartCount.toString()
        }else {
            countText.text = ""
        }
        redCircle.visibility = if (cartCount> 0) View.VISIBLE else View.GONE
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