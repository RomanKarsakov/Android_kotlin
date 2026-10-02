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
                .width(157.dp)
                .height(200.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFFF9F9F9))
        ) {
            Image(
                painter = painterResource(id = com.example.karsakov_andr.R.drawable.image_no),
                contentDescription = product.title,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxSize()

            )

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
                    painter = painterResource(id = com.example.karsakov_andr.R.drawable.shopping_bag_icon),
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
            text = "$ ${product.price}",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProductCardPreview() {

    val fakeProduct = Product(
        id = 1,
        title = "Black Simple Lamp",
        price = 12.00
    )

    Box(modifier = Modifier.width(180.dp).padding(16.dp)) {
        ProductCard(product = fakeProduct)
    }
}