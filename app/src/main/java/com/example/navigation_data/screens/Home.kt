package com.example.navigation_data.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.navigation_data.Routes


@Composable
fun Home(navController: NavHostController) {

    // Create a basic counter to display on screen
    var counter by remember {
        mutableStateOf(0)
    }
    var text by rememberSaveable { mutableStateOf("Text") }

    // Box composable to center Items
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White), contentAlignment = Alignment.Center
    ) {

        // A Column composable
        Column {

            TextField(
                value = text,
                onValueChange = {
                    text = it
                },
                label = { Text("Profile") }
            )


            // A Text Composable to show counter on Screen
            Text(text = "Home, Counter is $counter", color = Color.Black)



            // A button Composable which when clicked will increase the counter
            Button(onClick = { counter++ }) {
                Text(text = "Increment Counter", color = Color.White)
            }

            Spacer(modifier = Modifier.height(20.dp))

            // A button composable to navigate to Profile Screen
            Button(onClick = {
                navController.navigate(Routes.Profile.route +"/$text")
            }) {
                Text(text = "Navigate to Profile", color = Color.White)
            }

            Spacer(modifier = Modifier.height(20.dp))

            // A Button Composable to navigate to
            // Settings Screen when clicked
            Button(onClick = {
                navController.navigate(Routes.Settings.route + "/$counter")
            }) {
                Text(text = "Navigate to Settings", color = Color.White)
            }
        }
    }
}





