package com.huertohogar.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF67C13F),  // Green for garden theme
    secondary = Color(0xFF57A835), // Secondary green
    tertiary = Color(0xFF8BC34A)   // Tertiary green
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF4CAF50),  // Green for garden theme
    secondary = Color(0xFF388E3C), // Secondary green
    tertiary = Color(0xFF689F38)   // Tertiary green
)

@Composable
fun HuertoHogarTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}