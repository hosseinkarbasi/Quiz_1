package com.example.queiz1

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imgUrl")
fun show(iv: ImageView, url: String) {
    Glide
        .with(iv.context)
        .load(url)
        .into(iv)
}
