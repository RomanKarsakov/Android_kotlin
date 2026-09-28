package com.example.karsakov_andr.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.karsakov_andr.ui.components.CategoryItem // Убедитесь, что этот компонент тоже создан
import com.example.karsakov_andr.ui.components.ProductCard
import com.example.karsakov_andr.data.model.Product

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FurnitureShopScreen() {
    val categories = listOf("Popular", "Chair", "Table", "Armchair", "Bed")
    var selectedCategory by remember { mutableStateOf("Popular") }

    // Список ваших товаров с полем title
    val products = remember {
        listOf(
            Product(1, "Black Simple Lamp", 12.00),
            Product(2, "Minimal Stand", 25.00),
            Product(3, "Coffee Chair", 20.00),
            Product(4, "Simple Desk", 50.00)
        )
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "BEAUTIFUL",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 2.sp
                    )
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {
            // Верхняя панель категорий
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.padding(vertical = 16.dp)
            ) {
                items(categories) { category ->
                    CategoryItem(
                        name = category,
                        isSelected = category == selectedCategory,
                        onClick = { selectedCategory = category }
                    )
                }
            }

            // Две колонки товаров
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(products) { product ->
                    ProductCard(product = product)
                }
            }
        }
    }
}

// Превью для всего экрана, чтобы увидеть финальный результат прямо в студии
@Preview(showBackground = true)
@Composable
fun FurnitureShopScreenPreview() {
    FurnitureShopScreen()
}