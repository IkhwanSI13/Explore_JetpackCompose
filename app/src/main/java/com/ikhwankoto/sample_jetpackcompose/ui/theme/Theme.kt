package com.ikhwankoto.sample_jetpackcompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable

@Composable
fun Sample_JetpackComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    MaterialTheme(
        colors = if (darkTheme) DarkColorPalette else LightColorPalette,
        typography = MyComposeTypography,
        shapes = MyComposeShapes,
        content = content
    )
//    MaterialTheme(
//        colors = DarkColorPalette,
//        typography = Typography(),
//        shapes = Shapes(),
//        content = content
//    )
}