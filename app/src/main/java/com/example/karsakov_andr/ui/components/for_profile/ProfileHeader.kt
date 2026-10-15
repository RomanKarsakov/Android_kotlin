package com.example.karsakov_andr.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.karsakov_andr.R
import com.example.karsakov_andr.ui.theme.Karsakov_andrTheme
import com.example.karsakov_andr.ui.theme.MyTheme

@Composable
fun ProfileHeader(
    name: String,
    email: String,
    avatarResId: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = avatarResId),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = name,
                style = MyTheme.typography.profileName,
                color = MyTheme.colors.blacktext
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = email,
                style = MyTheme.typography.profileEmail,
                color = MyTheme.colors.gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileHeaderPreview() {
    Karsakov_andrTheme {
        ProfileHeader(
            name = "Bruno Pham",
            email = "bruno203@gmail.com",
            avatarResId = R.drawable.avatar
        )
    }
}
