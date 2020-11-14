package com.ydh.androidweektwo.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.ydh.androidweektwo.R
import com.ydh.androidweektwo.databinding.FragmentFavoriteBinding


class FavoriteFragment : Fragment() {
    lateinit var binding: FragmentFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorite,container, false)


        return binding.root

    }

}