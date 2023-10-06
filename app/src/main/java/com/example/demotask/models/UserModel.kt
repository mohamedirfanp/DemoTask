package com.example.demotask.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_data")
data class UserModel(
    @PrimaryKey(autoGenerate = true)
    var userId: Int = 0,

    @ColumnInfo(name = "user_name")
    var userName: String,

    @ColumnInfo(name = "user_mobile_number")
    var userMobileNumber : String,

    @ColumnInfo(name = "user_password")
    var userPassword : String,

    @ColumnInfo(name = "user_email")
    var userEmail : String

) {
    constructor() : this(0,"","","","")
}