package com.syfuzzaman.mvvm_android_skeleton.data.network.model

import com.google.gson.annotations.SerializedName

sealed class Resource<out T> {
    data class Success<out T>(
        @SerializedName("data")
        val data: T
    ) : Resource<T>()

    data class Failure<out T>(
        @SerializedName("error")
        val error: Error
    ) : Resource<T>()
}