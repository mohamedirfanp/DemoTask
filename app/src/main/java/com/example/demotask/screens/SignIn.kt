package com.example.demotask.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.demotask.statemanagement.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignIn(navController: NavController, userViewModel: UserViewModel)
{
    var isError by remember {
        mutableStateOf(false)
    };
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Sign In", fontSize = 30.sp)
        Spacer(modifier = Modifier.padding(10.dp))
        if(isError)
        {
            Text(text = "Invalid Credentials", color = Color.Red)
        }
        OutlinedTextField(value = userViewModel.userData.userEmail, onValueChange = {
            userViewModel.userData = userViewModel.userData.copy(userEmail = it)
        },
            placeholder = ({
                Text(text = "Enter Email")
            })
        )
        Spacer(modifier = Modifier.padding(10.dp))
        OutlinedTextField(
            value = userViewModel.userData.userPassword,
            onValueChange = {
                userViewModel.userData = userViewModel.userData.copy(userPassword = it)
            },
            placeholder = {
                Text(text = "Enter Password")
            },
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Button(onClick = {
            userViewModel.SignInUser()
            if(userViewModel.isLogined === "Fail")
                isError = true
            else if(userViewModel.isLogined === "Success")
                navController.navigate("home")
        }) {
            Text(text = "Sign In")
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Divider(modifier = Modifier.padding(start = 50.dp, end = 50.dp))

        Row {
            Text(text = "Don't have a account, ", fontSize = 20.sp)
            Text(
                text = "Sign Up",
                modifier = Modifier.clickable {
                    userViewModel.ClearData()
                    navController.navigate("signUp")

                                              },
                fontSize = 20.sp,
                color = Color.Blue, // Replace with your desired color
                textDecoration = TextDecoration.Underline
            )
        }
    }

}