package com.syfuzzaman.mvvm_android_skeleton.ui

import com.syfuzzaman.mvvm_android_skeleton.ui.common.BaseListItemCallback
import com.syfuzzaman.mvvm_android_skeleton.ui.common.BasePagingDataAdapter
import com.syfuzzaman.mvvm_android_skeleton.ui.common.ItemComparator
import com.syfuzzaman.mvvm_android_skeleton.R

class UserListAdapter <T: Any> (
    callback: BaseListItemCallback<T>
) : BasePagingDataAdapter<T> (callback, ItemComparator()){
    override fun getItemViewType(position: Int): Int {
        return R.layout.list_item_user
    }
}