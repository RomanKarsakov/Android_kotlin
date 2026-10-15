package com.example.karsakov_andr.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.karsakov_andr.ui.theme.Karsakov_andrTheme
import com.example.karsakov_andr.ui.theme.MyTheme

// Модель данных для элемента списка
data class ProfileMenuItem(
    val id: String,
    val title: String,
    val subtitle: String
)

@Composable
fun ProfileMenuCard(
    item: ProfileMenuItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = MyTheme.colors.white
        ),
        shape = RoundedCornerShape(4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 18.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = item.title,
                    style = MyTheme.typography.cardTitle,
                    color = MyTheme.colors.blacktext
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = item.subtitle,
                    style = MyTheme.typography.cardSubtitle,
                    color = MyTheme.colors.gray
                )
            }
            Icon(
                imageVector =  // Исправленный вызов иконки
                contentDescription = "Open ${item.title}",
                tint = MyTheme.colors.blacktext,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileMenuCardPreview() {
    Karsakov_andrTheme {
        Box(modifier = Modifier.padding(16.dp)) {
            ProfileMenuCard(
                item = ProfileMenuItem("orders", "My orders", "Already have 10 orders"),
                onClick = {}
            )
        }
    }
}
