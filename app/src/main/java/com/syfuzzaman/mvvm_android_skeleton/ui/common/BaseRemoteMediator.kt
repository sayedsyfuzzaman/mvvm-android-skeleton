package com.syfuzzaman.mvvm_android_skeleton.ui.common

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator

@OptIn(ExperimentalPagingApi::class)
class BaseRemoteMediator<T: Any>: RemoteMediator<Int, T>() {
    @OptIn(ExperimentalPagingApi::class)
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, T>
    ): MediatorResult {
        return MediatorResult.Error(NullPointerException())
    }
}