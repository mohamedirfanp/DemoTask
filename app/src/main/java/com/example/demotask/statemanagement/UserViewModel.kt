package com.example.demotask.statemanagement

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.demotask.DAO.UserDao
import com.example.demotask.models.UserModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class UserViewModel(private val userDao: UserDao, private val scope : CoroutineScope) : ViewModel()
{
    var userData by mutableStateOf(UserModel());
    var requestedUserData by mutableStateOf<List<UserModel>>(emptyList())

    var isLogined by mutableStateOf("Not")

    init {
        var userDao = userDao
    }

    fun ClearData()
    {
        userData = UserModel()
        requestedUserData = emptyList()
    }

    fun SignUpUser()
    {
        scope.launch {
            try {
                userDao.SignUp(userData)
                ClearData()
            }
            catch (ex: Exception)
            {
                println("Error Cancelled")
            }
        }
    }

    fun SignInUser()
    {
        scope.launch {
            try {
                var response = userDao.getUserByEmailAndPassword(userData.userEmail, userData.userPassword)
                println(response)
                if(response.isEmpty())
                    isLogined = "Fail"
                else
                {
                    isLogined = "Success"
                }

            }
            catch (ex: Exception)
            {
                println("Error Cancelled")
            }
        }
    }

    fun GetDetails() {
        scope.launch{
            try {
                requestedUserData = userDao.getDetail(userData.userEmail)
            }
            catch (ex: Exception)
            {
                println("Error Cancelled")
            }
        }
    }

    fun SignOut()
    {
        isLogined = "Not"
        ClearData()

    }
}


