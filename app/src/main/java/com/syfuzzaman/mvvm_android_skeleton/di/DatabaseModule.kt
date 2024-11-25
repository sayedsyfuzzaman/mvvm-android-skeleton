package com.syfuzzaman.mvvm_android_skeleton.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.syfuzzaman.mvvm_android_skeleton.data.database.HairDao
import com.syfuzzaman.mvvm_android_skeleton.data.database.MyDatabase
import com.syfuzzaman.mvvm_android_skeleton.data.database.UserListDao
import com.syfuzzaman.mvvm_android_skeleton.data.network.api.User
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext app: Context): MyDatabase {
        return Room.databaseBuilder(app,
            MyDatabase::class.java, MyDatabase.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    /*@Singleton
    @Provides
    fun providesUserListDao(db: MyDatabase) = db.dao*/

    @Provides
    @Singleton
    fun providesHairDao(db: MyDatabase): HairDao {
        return db.dao()
    }

    @Provides
    @Singleton
    fun providesUserListDao(db: MyDatabase): UserListDao{
        return db.userListDao()
    }
}