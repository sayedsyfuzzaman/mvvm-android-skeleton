package com.syfuzzaman.mvvm_android_skeleton.ui.common

interface BaseApiService<T: Any> {
    suspend fun loadData(offset: Int, limit: Int): List<T>
}