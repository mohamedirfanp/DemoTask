package com.example.demotask.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.demotask.models.UserModel
import com.example.demotask.statemanagement.UserViewModel

@Composable
fun HomeScreen(navController: NavController,userViewModel: UserViewModel)
{
    userViewModel.GetDetails();
    val userDetails = userViewModel.requestedUserData;

    println(userDetails)
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(text = "User Details", fontSize = 20.sp)
        LazyColumn()
        {
            items(userDetails!!) { user ->
                UserItem(user = user)
            }
        }
        Button(onClick = {
            userViewModel.SignOut()
        }) {
            Text(text = "Sign out")
        }
    }
}
@Composable
fun UserItem(user: UserModel)
{
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Name: ${user.userName}")
            Text(text = "Email: ${user.userEmail}")
            Text(text = "Mobile Number ${user.userMobileNumber}")

        }
    }

}



