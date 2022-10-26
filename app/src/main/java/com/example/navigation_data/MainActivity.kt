package com.example.navigation_data

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigation_data.screens.Home
import com.example.navigation_data.screens.Profile
import com.example.navigation_data.screens.Setting
import com.example.navigation_data.ui.theme.NavigationDataTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationDataTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   ScreenMain()
                }
            }
        }
    }
}

@Composable
fun ScreenMain() {
    val navController = rememberNavController()
       NavHost(navController = navController, startDestination = Routes.Home.route)    {

           composable(Routes.Home.route) {

               Home(navController = navController)
           }
           composable(Routes.Profile.route + "/{id}") {navBackStack ->
               val txt = navBackStack.arguments?.getString("id")

                   Profile(txt = txt)

           }
           composable(Routes.Settings.route + "/{id}") {navBackStack ->
               val counter = navBackStack.arguments?.getString("id")
               Setting(counter = counter)
           }
       }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NavigationDataTheme {
        Greeting("Android")
    }
}