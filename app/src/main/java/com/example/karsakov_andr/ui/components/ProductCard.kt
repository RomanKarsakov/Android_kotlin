package com.example.karsakov_andr.ui.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.karsakov_andr.data.model.Product

@Composable
fun ProductCard(
    product: Product,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFFF9F9F9))
        ) {
            // Используем одну стандартную системную картинку для всех товаров
            Image(
                painter = painterResource(id = android.R.drawable.ic_menu_report_image),
                contentDescription = product.title,
                contentScale = ContentScale.Fit, // Подгоняем по размеру
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp) // Небольшой отступ, чтобы иконка смотрелась аккуратно
            )

            // Кнопка сумки/корзины
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(12.dp)
                    .size(32.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.Black.copy(alpha = 0.3f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_input_add), // Системная иконка плюсика
                    contentDescription = "Добавить в корзину",
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                )

            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = product.title,
            fontSize = 14.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = "$ ${String.format("%.2f", product.price)}",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProductCardPreview() {
    // Создаем фейковый объект продукта для отображения в дизайнере
    val fakeProduct = Product(
        id = 1,
        title = "Black Simple Lamp",
        price = 12.00
    )

    // Оборачиваем в Box с фиксированной шириной, чтобы карточка не растягивалась на весь экран превью
    Box(modifier = Modifier.width(180.dp).padding(16.dp)) {
        ProductCard(product = fakeProduct)
    }
}