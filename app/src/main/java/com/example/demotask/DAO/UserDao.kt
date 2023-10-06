package com.example.demotask.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.demotask.models.UserModel

@Dao
interface UserDao {

    @Insert
    suspend fun SignUp(item: UserModel)

    @Query("SELECT * FROM user_data WHERE user_email = :userInput AND user_password = :userPassword")
    suspend fun getUserByEmailAndPassword(userInput: String, userPassword: String): List<UserModel>

    @Query("SELECT * FROM user_data WHERE user_email = :userInput")
    suspend fun getDetail(userInput: String): List<UserModel>

}