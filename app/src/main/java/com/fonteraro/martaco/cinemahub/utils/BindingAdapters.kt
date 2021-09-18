package com.fonteraro.martaco.cinemahub.utils

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

@BindingAdapter("imageUrl")
fun loadImage(view: AppCompatImageView, imageUrl: String?) {
    if (imageUrl.isNullOrEmpty().not()) {
        Glide.with(view.context)
            .load(imageUrl)
            .dontAnimate()
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .into(view)
    }
}
