package com.syfuzzaman.mvvm_android_skeleton.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.syfuzzaman.mvvm_android_skeleton.data.network.api.User

@Database(
    entities = [
        HairEntity::class, User::class
               ],
    version = 1,
    exportSchema = false
)

@TypeConverters(Converters::class)
abstract class MyDatabase : RoomDatabase() {
    abstract fun dao(): HairDao
    abstract fun userListDao(): UserListDao
    companion object {
        const val DB_NAME = "my-db"
    }
}