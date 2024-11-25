package com.syfuzzaman.mvvm_android_skeleton.ui.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.size.Scale
import javax.inject.Singleton
import com.syfuzzaman.mvvm_android_skeleton.R

@Singleton
class BindingUtil {
    companion object {
        @JvmStatic
        @BindingAdapter("loadImageResource")
        fun loadImageFromResource(view: ImageView, image: Int) {
            view.load(image)
        }

        @JvmStatic
        @BindingAdapter(value = ["loadImageFromUrl", "maintainRatio"], requireAll = false)
        fun bindImageFromUrl(view: ImageView, imageUrl: String?, maintainRatio: Boolean = true) {
            view.load(imageUrl){
                crossfade(true)
//                placeholder(R.drawable.poster_placeholder)
//                error(R.drawable.poster_placeholder)
                scale(Scale.FILL)
            }
        }
    }
}