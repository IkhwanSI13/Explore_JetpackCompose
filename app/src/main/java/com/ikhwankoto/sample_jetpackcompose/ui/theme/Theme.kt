package com.ikhwankoto.sample_jetpackcompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

// TODO(Ikhwan): dynamic color for theme
// Material 3 strongly focuses on user personalization - a new feature in
// Material 3 is Dynamic Color which creates a theme for your app based on
// the user's wallpaper. This way if the user loves green and has a blue
// phone background, their Woof app will also be blue to reflect that.
// Dynamic theming is only on certain devices that are running Android 12
// and up.
@Composable
fun Sample_JetpackComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    MaterialTheme(
        colors = if (darkTheme) DarkColors else LightColors,
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