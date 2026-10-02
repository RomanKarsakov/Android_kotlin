package com.example.karsakov_andr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.karsakov_andr.data.model.Recipe
import com.example.karsakov_andr.ui.screen.ShopScreen
import com.example.karsakov_andr.ui.viewmodel.ProductViewModel
import com.example.karsakov_andr.ui.theme.Karsakov_andrTheme
import com.example.karsakov_andr.ui.viewmodel.PostViewModel
import com.example.karsakov_andr.ui.viewmodel.RecipeViewModel
import com.example.karsakov_andr.ui.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShopScreen()
            }
        }
    }

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview
@Composable
fun GreetingPreview() {
    Karsakov_andrTheme {
        Greeting("Android")
    }
}