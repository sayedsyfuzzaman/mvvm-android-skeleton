package com.syfuzzaman.mvvm_android_skeleton.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.syfuzzaman.mvvm_android_skeleton.data.network.api.User

@Dao
interface UserListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<User>)

    @Query("SELECT users.firstName, hair.* FROM users INNER JOIN hair on users.id = hair.userId WHERE hair.color = :hair")
    fun getUsersByHair(hair: String): List<User>
}