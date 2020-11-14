package com.ydh.androidweektwo.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.ydh.androidweektwo.R
import com.ydh.androidweektwo.databinding.FragmentCartBinding

class CartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentCartBinding>(inflater,R.layout.fragment_cart, container, false)
        return binding.root
    }


}