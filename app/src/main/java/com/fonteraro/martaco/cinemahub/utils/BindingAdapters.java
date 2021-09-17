package com.fonteraro.martaco.cinemahub.utils;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

public abstract class BindingAdapters {

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.get()
                .load(imageUrl)
                .noPlaceholder()
                .noFade()
                .into(view);
    }
}
