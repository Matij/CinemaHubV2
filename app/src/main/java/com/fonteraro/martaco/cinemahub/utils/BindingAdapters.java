package com.fonteraro.martaco.cinemahub.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public abstract class BindingAdapters {

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.get()
                .load(imageUrl)
                .noPlaceholder()
                .noFade()
                .into(view);
    }
}
