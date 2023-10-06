package com.example.demotask.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.demotask.DAO.UserDao
import com.example.demotask.models.UserModel


@Database(entities = [UserModel::class], version = 1)
abstract class DBConnection : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: DBConnection? = null

        fun getDatabase(context: Context): DBConnection {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DBConnection::class.java,
                    "users.db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}