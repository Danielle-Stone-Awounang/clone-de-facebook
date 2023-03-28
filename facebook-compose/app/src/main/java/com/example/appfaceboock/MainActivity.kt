package com.example.appfaceboock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appfaceboock.ui.theme.AppFaceboockTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppFaceboockTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                val homeRoute = "home"
                NavHost(navController, startDestination = homeRoute){
                    val signinRoute = "signin"
                composable(homeRoute){
                    HomeScreen(
                        navigateToSignIn = {
                            navController.navigate(signinRoute){
                                popUpTo(homeRoute){
                                    inclusive = true
                                }
                            }
                        }
                    )
                }
                    composable(signinRoute){
                        SignInScreen()
                    }

                }


            }
        }
    }

    private fun composable(route: String) {

    }
}

@Composable
fun TransparentSystemDars(){
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()

    DisposableEffect(systemUiController, useDarkIcons) {
        // pour Mettre à jour toutes les couleurs de la barre système pour qu’elles soient transparentes et utilisez
        //  icônes sombres si nous sommes dans le thème clair
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = useDarkIcons
        )

        // setStatusBarColor() and setNavigationBarColor() also exist

        onDispose {}
    }
}


//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    AppFaceboockTheme {
//        Greeting("Android")
//    }
//}