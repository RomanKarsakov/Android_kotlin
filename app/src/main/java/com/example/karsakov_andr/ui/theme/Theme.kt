package com.example.karsakov_andr.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun Karsakov_andrTheme(
    content: @Composable () -> Unit
) {
    // 1. Наполняем цветами вашу модель AppColors
    val colors = AppColors(
        blacktext = Color(0xFF242424),      // Темный текст и иконки
        gray = Color(0xFF808080),           // Серый вспомогательный текст
        white = Color(0xFFFFFFFF)  // Белые карточки
    )

    // 2. Наполняем шрифтами вашу модель AppTypography
    val typography = AppTypography(
        profileName = TextStyle(
            fontFamily = NunitoBoldFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            lineHeight = 28.sp
        ),
        cardTitle = TextStyle(
            fontFamily = NunitoMediumFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            lineHeight = 24.sp
        ),
        profileEmail = TextStyle(
            fontFamily = NunitoRegularFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = 20.sp
        ),
        cardSubtitle = TextStyle(
            fontFamily = NunitoRegularFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            lineHeight = 16.sp
        )
    )

    // 3. Пробрасываем созданные палитры и шрифты вниз по дереву компонентов
    CompositionLocalProvider(
        LocalAppColors provides colors,
        LocalAppTypography provides typography
    ) {
        MaterialTheme(
            content = content
        )
    }
}
object MyTheme {
    val colors: AppColors
        @Composable
        get() = LocalAppColors.current

    val typography: AppTypography
        @Composable
        get() = LocalAppTypography.current
}