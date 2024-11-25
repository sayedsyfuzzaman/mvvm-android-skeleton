package com.syfuzzaman.mvvm_android_skeleton.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hair")
data class HairEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val userId: Int,
    val color: String,
    val type: String,
)
