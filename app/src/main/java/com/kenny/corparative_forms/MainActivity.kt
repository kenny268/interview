package com.kenny.corparative_forms

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kenny.corparative_forms.pages.Welcome
import com.kenny.corparative_forms.pages.Login
import com.kenny.corparative_forms.ui.theme.Corparative_formsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Corparative_formsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
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
    NavHost(navController = navController, startDestination ="login" ) {
        composable("login"){ Login(navController) }
        composable("welcome"){ Welcome(navController = navController) }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Corparative_formsTheme {
        ScreenMain()
    }
}