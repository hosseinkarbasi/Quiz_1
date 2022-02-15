package com.example.queiz1

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.queiz1.databinding.TreeBinding

class Tree:Fragment(R.layout.tree) {

    private lateinit var binding: TreeBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = DataBindingUtil.bind(view)!!
    }
}