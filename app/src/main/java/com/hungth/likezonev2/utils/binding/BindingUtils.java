package com.hungth.likezonev2.utils.binding;

import android.graphics.Bitmap;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.textfield.TextInputLayout;

public final class BindingUtils {

    private BindingUtils() {
        // No-op
    }

    /**
     * setErrorMessage for TextInputLayout
     */
    @BindingAdapter({"errorText"})
    public static void setErrorMessage(TextInputLayout view, String errorMessage) {
        view.setError(errorMessage);
    }

    /**
     * setAdapter For RecyclerView
     */
    @BindingAdapter({"recyclerAdapter"})
    public static void setAdapterForRecyclerView(RecyclerView recyclerView,
                                                 RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .apply(new RequestOptions().centerCrop())
                .into(view);
    }

    @BindingAdapter("imageBitmap")
    public static void loadBitmap(ImageView view, Bitmap bitmap) {
        view.setImageBitmap(bitmap);
    }
}
