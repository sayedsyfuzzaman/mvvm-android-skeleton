package com.syfuzzaman.mvvm_android_skeleton.data.network.api

import android.util.Log
import com.syfuzzaman.mvvm_android_skeleton.ui.common.BaseApiService
import javax.inject.Inject

class UserListApiService @Inject constructor(
    private val internalApi: InternalApi
) : BaseApiService<User>, PagingErrorHandling() {

    override suspend fun loadData(offset: Int, limit: Int): List<User> {
        return safeApiCallPaging {
            val response = internalApi.getUserList(limit, offset)

            if (response.users.isEmpty()) {
                throw Exception("No data found")
            }
            response.users
        }
    }

}