package com.example.karsakov_andr.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.karsakov_andr.R

val NunitoRegularFamily = FontFamily(Font(R.font.nunito_sans))
val NunitoMediumFamily = FontFamily(Font(R.font.nunito_sans_medium))
val NunitoBoldFamily = FontFamily(Font(R.font.nunito_sans_bold))

val Typography = Typography()

data class AppTypography(
    val profileName: TextStyle,
    val cardTitle: TextStyle,
    val profileEmail: TextStyle,
    val cardSubtitle: TextStyle
)


val LocalAppTypography = staticCompositionLocalOf {
    AppTypography(
        profileName = TextStyle(
            fontFamily = NunitoBoldFamily,
            fontSize = 20.sp,
            lineHeight = 28.sp
        ),
        cardTitle = TextStyle(
            fontFamily = NunitoMediumFamily,
            fontSize = 18.sp,
            lineHeight = 24.sp
        ),
        profileEmail = TextStyle(
            fontFamily = NunitoRegularFamily,
            fontSize = 14.sp,
            lineHeight = 20.sp
        ),
        cardSubtitle = TextStyle(
            fontFamily = NunitoRegularFamily,
            fontSize = 12.sp,
            lineHeight = 16.sp
        )
    )
}

object CustomTheme {
    val typography: AppTypography
        @Composable
        get() = LocalAppTypography.current
}
