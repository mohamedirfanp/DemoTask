package com.example.demotask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.demotask.data.DBConnection
import com.example.demotask.screens.HomeScreen
import com.example.demotask.screens.SignIn
import com.example.demotask.screens.SignUp
import com.example.demotask.statemanagement.UserViewModel
import com.example.demotask.ui.theme.DemoTaskTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTaskTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val database = DBConnection.getDatabase(applicationContext)
                    val myDao = database.userDao();
                    val navController = rememberNavController()

                    val scope = rememberCoroutineScope()

                    val userViewModel = UserViewModel(myDao, scope);

                    NavHost(
                        navController = navController,
                        startDestination = "signIn"
                    )
                    {

                        composable("home")
                        {
                            HomeScreen(navController = navController, userViewModel = userViewModel)
                        }

                        composable("signIn")
                        {
                            SignIn(navController = navController, userViewModel = userViewModel)
                        }

                        composable("signUp")
                        {
                            SignUp(navController = navController, userViewModel = userViewModel)
                        }
                    }
                }
            }
        }
    }
}
