package com.example.lottieapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [UserBean::class, LoginStatus::class, ItemBean::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao
    abstract fun getLoginStatusDao(): LoginStatusDao
    abstract fun getItemDao(): ItemDao

    companion object {
        private var instance: UserDatabase? = null

        fun getInstance(context: Context): UserDatabase {
            return instance ?: Room.databaseBuilder(
                context,
                UserDatabase::class.java,
                "user_db"
            ).build()
        }
    }
}