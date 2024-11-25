package com.syfuzzaman.mvvm_android_skeleton.ui.common

import android.view.View

interface BaseListItemCallback<T : Any> {
    fun onItemClicked(item: T) {}
    fun onItemClicked(view: View, item: T) {}
}