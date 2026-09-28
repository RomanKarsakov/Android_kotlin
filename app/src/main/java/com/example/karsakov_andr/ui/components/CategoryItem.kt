package com.example.karsakov_andr.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CategoryItem(
    name: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.width(68.dp) // Фиксированная ширина для выравнивания текста
    ) {
        IconButton(
            onClick = onClick,
            modifier = Modifier
                .size(56.dp) // Размер квадратной кнопки
                .clip(RoundedCornerShape(14.dp)) // Скругление углов как на макете
                .background(if (isSelected) Color.Black else Color(0xFFF5F5F5)) // Черный фон для выбранной
        ) {
            Icon(
                painter = painterResource(id = android.R.drawable.ic_menu_gallery), // Работает везде
                contentDescription = name,
                tint = if (isSelected) Color.White else Color(0xFFB0B0B0),
                modifier = Modifier.size(24.dp)
            )
        }

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = name,
            fontSize = 13.sp,
            color = if (isSelected) Color.Black else Color(0xFF909090),
            fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal
        )
    }
}

// --- ПРЕВЬЮ КОМПОНЕНТА ---
@Preview(showBackground = true)
@Composable
fun CategoryItemPreview() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        // Показываем активную и неактивную категорию для теста
        CategoryItem(name = "Popular", isSelected = true, onClick = {})
        CategoryItem(name = "Chair", isSelected = false, onClick = {})
    }
}
