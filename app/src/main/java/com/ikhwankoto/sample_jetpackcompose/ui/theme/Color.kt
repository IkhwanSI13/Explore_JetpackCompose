package com.ikhwankoto.sample_jetpackcompose.ui.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal100 = Color(0xFF5EFDED)
val Teal200 = Color(0xFF03DAC5)
val Green100 = Color(0xFF96EDB3)
val Green200 = Color(0xFF20BF55)
val Green800 = Color(0xFF2E7D32)
val Grey200 = Color(0xFFB9C1CA)

val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    onPrimary = Purple200,
    secondary = Teal200,
    secondaryVariant = Color(0xFF018786),
    onSecondary = Teal100,
    background = Grey200,
    onBackground = Color.White,
    surface = Green200,
    onSurface = Green100,
    error = Color(0xFFB00020),
    onError = Color(0xFFFF708A)
)