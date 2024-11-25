package com.syfuzzaman.mvvm_android_skeleton.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface HairDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(hairEntity: HairEntity)
}