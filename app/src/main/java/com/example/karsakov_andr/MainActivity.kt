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
import com.example.karsakov_andr.ui.viewmodel.ProductViewModel
import com.example.karsakov_andr.ui.theme.Karsakov_andrTheme
import com.example.karsakov_andr.ui.viewmodel.RecipeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val productViewModel: ProductViewModel = viewModel()
            val recipeViewModel: RecipeViewModel = viewModel()
            LaunchedEffect(Unit) {
                productViewModel.fetch()
            }

            val request = Recipe(
                name = "Куриное филе в сливочно-чесночном соусе",
                ingredients = listOf(
                    "Куриное филе", "сливки", "чеснок", "сливочное масло",
                    "растительное масло", "твердый сыр", "соль",
                    "черный перец", "итальянские травы"
                ),
                instructions = listOf(
                    "Нарезать филе", "Обжарить с чесноком",
                    "Добавить сливки и специи", "Тушить до готовности"
                ),
                prepTimeMinutes = 25,
                difficulty = "Easy"
            )
            LaunchedEffect(Unit) {
                recipeViewModel.addRecipe(request)
            }

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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Karsakov_andrTheme {
        Greeting("Android")
    }
}