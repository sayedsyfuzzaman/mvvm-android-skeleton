package com.syfuzzaman.mvvm_android_skeleton.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import com.syfuzzaman.mvvm_android_skeleton.data.database.HairDao
import com.syfuzzaman.mvvm_android_skeleton.data.database.HairEntity
import com.syfuzzaman.mvvm_android_skeleton.data.database.UserListDao
import com.syfuzzaman.mvvm_android_skeleton.data.network.api.User
import com.syfuzzaman.mvvm_android_skeleton.data.network.api.UserListApiService
import com.syfuzzaman.mvvm_android_skeleton.ui.common.BaseListRepositoryImpl
import com.syfuzzaman.mvvm_android_skeleton.ui.common.BaseNetworkPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userListApiService: UserListApiService,
    private val dao: HairDao,
    private val userListDao: UserListDao
): ViewModel (){
    @OptIn(ExperimentalPagingApi::class)
    fun getUsersData(limit: Int, offset: Int): Flow<PagingData<User>> {
        return BaseListRepositoryImpl(
            pagingFactory = {
                BaseNetworkPagingSource(userListApiService, limit, offset)
            },
        ).getList(limit)
    }

    fun saveUsersData(){
        viewModelScope.launch(Dispatchers.IO){
            val data = userListApiService.loadData(0, 10)
            userListDao.insertAll(data)
            data.forEach {
                val entity = HairEntity(
                    id = 0,
                    userId = it.id ?: 0,
                    color = it.hair?.color ?: "",
                    type = it.hair?.type ?: ""
                )
                dao.insert(entity)
            }
        }
    }
}