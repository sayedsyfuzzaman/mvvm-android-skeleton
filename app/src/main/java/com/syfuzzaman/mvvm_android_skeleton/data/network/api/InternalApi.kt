package com.syfuzzaman.mvvm_android_skeleton.data.network.api

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface InternalApi {
    @GET("users")
    suspend fun getUserList(
        @Query("limit") limit: Int,
        @Query("skip") offset: Int
    ): UserListApiResponse
}