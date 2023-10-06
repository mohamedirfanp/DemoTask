package com.example.demotask.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.demotask.statemanagement.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun SignUp(navController: NavController, userViewModel: UserViewModel)
{
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Sign Up", fontSize = 20.sp)
        Spacer(modifier = Modifier.padding(10.dp))
        OutlinedTextField(value = userViewModel.userData.userName , onValueChange = {
            userViewModel.userData = userViewModel.userData.copy(userName = it)
        },
            placeholder = ({
                Text(text = "Enter user name")
            }))
        Spacer(modifier = Modifier.padding(10.dp))
        OutlinedTextField(value = userViewModel.userData.userEmail, onValueChange = {
            userViewModel.userData = userViewModel.userData.copy(userEmail = it)
        },
            placeholder = ({
                Text(text = "Enter user email")
            }))
        Spacer(modifier = Modifier.padding(10.dp))
        OutlinedTextField(value = userViewModel.userData.userMobileNumber, onValueChange = {
            userViewModel.userData = userViewModel.userData.copy(userMobileNumber = it)
        },
            placeholder = ({
                Text(text = "Enter user mobile number")
            }),
            )
        Spacer(modifier = Modifier.padding(10.dp))
        OutlinedTextField(value = userViewModel.userData.userPassword, onValueChange = {
            userViewModel.userData = userViewModel.userData.copy(userPassword = it)
        }, visualTransformation = PasswordVisualTransformation(),
            placeholder = ({
                Text(text = "Enter user password")
            }))
        Spacer(modifier = Modifier.padding(10.dp))
        Button(onClick = {
            userViewModel.SignUpUser()
            navController.navigate("signIn")

        }) {
            Text(text = "Sign Up")
        }
        Divider()
        Spacer(modifier = Modifier.padding(10.dp))
        Row{
            Text(text = "Create a account ,", fontSize = 20.sp)
            Text(
                text = "Sign In",
                modifier = Modifier.clickable {
                    userViewModel.ClearData()
                    navController.navigate("signIn")
                },
                fontSize = 20.sp,
                color = Color.Blue,
                textDecoration = TextDecoration.Underline
            )
        }
    }
}