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

/**
 * Generate Colors from https://m3.material.io/theme-builder#/custom and use Export feature
 * */

/**
 * Light Theme
 * */
val md_theme_light_primary = Color(0xFF006397)
val md_theme_light_onPrimary = Color(0xFFFFFFFF)
val md_theme_light_primaryContainer = Color(0xFFCCE5FF)
val md_theme_light_onPrimaryContainer = Color(0xFF001D31)
val md_theme_light_secondary = Color(0xFF006C51)
val md_theme_light_onSecondary = Color(0xFFFFFFFF)
val md_theme_light_secondaryContainer = Color(0xFF83F8CE)
val md_theme_light_onSecondaryContainer = Color(0xFF002117)
val md_theme_light_tertiary = Color(0xFF9C404C)
val md_theme_light_onTertiary = Color(0xFFFFFFFF)
val md_theme_light_tertiaryContainer = Color(0xFFFFDADB)
val md_theme_light_onTertiaryContainer = Color(0xFF40000E)
val md_theme_light_error = Color(0xFFBA1A1A)
val md_theme_light_errorContainer = Color(0xFFFFDAD6)
val md_theme_light_onError = Color(0xFFFFFFFF)
val md_theme_light_onErrorContainer = Color(0xFF410002)
val md_theme_light_background = Color(0xFFFCFCFF)
val md_theme_light_onBackground = Color(0xFF1A1C1E)
val md_theme_light_surface = Color(0xFFFCFCFF)
val md_theme_light_onSurface = Color(0xFF1A1C1E)
val md_theme_light_surfaceVariant = Color(0xFFDEE3EB)
val md_theme_light_onSurfaceVariant = Color(0xFF42474E)
val md_theme_light_outline = Color(0xFF72787E)
val md_theme_light_inverseOnSurface = Color(0xFFF0F0F4)
val md_theme_light_inverseSurface = Color(0xFF2F3033)
val md_theme_light_inversePrimary = Color(0xFF93CCFF)
val md_theme_light_shadow = Color(0xFF000000)
val md_theme_light_surfaceTint = Color(0xFF006397)
val md_theme_light_outlineVariant = Color(0xFFC2C7CE)
val md_theme_light_scrim = Color(0xFF000000)

/// TODO(Ikhwan): upgrade compose, use lightColorSchema instead of lightColors
val LightColors = lightColors(
    primary = md_theme_light_primary,
    onPrimary = md_theme_light_onPrimary,
//    primaryContainer = md_theme_light_primaryContainer,
//    onPrimaryContainer = md_theme_light_onPrimaryContainer,
    secondary = md_theme_light_secondary,
    onSecondary = md_theme_light_onSecondary,
//    secondaryContainer = md_theme_light_secondaryContainer,
//    onSecondaryContainer = md_theme_light_onSecondaryContainer,
//    tertiary = md_theme_light_tertiary,
//    onTertiary = md_theme_light_onTertiary,
//    tertiaryContainer = md_theme_light_tertiaryContainer,
//    onTertiaryContainer = md_theme_light_onTertiaryContainer,
    error = md_theme_light_error,
//    errorContainer = md_theme_light_errorContainer,
    onError = md_theme_light_onError,
//    onErrorContainer = md_theme_light_onErrorContainer,
    background = md_theme_light_background,
    onBackground = md_theme_light_onBackground,
    surface = md_theme_light_surface,
    onSurface = md_theme_light_onSurface,
//    surfaceVariant = md_theme_light_surfaceVariant,
//    onSurfaceVariant = md_theme_light_onSurfaceVariant,
//    outline = md_theme_light_outline,
//    inverseOnSurface = md_theme_light_inverseOnSurface,
//    inverseSurface = md_theme_light_inverseSurface,
//    inversePrimary = md_theme_light_inversePrimary,
//    surfaceTint = md_theme_light_surfaceTint,
//    outlineVariant = md_theme_light_outlineVariant,
//    scrim = md_theme_light_scrim,
)

/**
 * Dark Theme
 * */
val md_theme_dark_primary = Color(0xFF93CCFF)
val md_theme_dark_onPrimary = Color(0xFF003351)
val md_theme_dark_primaryContainer = Color(0xFF004B73)
val md_theme_dark_onPrimaryContainer = Color(0xFFCCE5FF)
val md_theme_dark_secondary = Color(0xFF65DBB3)
val md_theme_dark_onSecondary = Color(0xFF003829)
val md_theme_dark_secondaryContainer = Color(0xFF00513D)
val md_theme_dark_onSecondaryContainer = Color(0xFF83F8CE)
val md_theme_dark_tertiary = Color(0xFFFFB2B8)
val md_theme_dark_onTertiary = Color(0xFF5F1221)
val md_theme_dark_tertiaryContainer = Color(0xFF7D2935)
val md_theme_dark_onTertiaryContainer = Color(0xFFFFDADB)
val md_theme_dark_error = Color(0xFFFFB4AB)
val md_theme_dark_errorContainer = Color(0xFF93000A)
val md_theme_dark_onError = Color(0xFF690005)
val md_theme_dark_onErrorContainer = Color(0xFFFFDAD6)
val md_theme_dark_background = Color(0xFF1A1C1E)
val md_theme_dark_onBackground = Color(0xFFE2E2E5)
val md_theme_dark_surface = Color(0xFF1A1C1E)
val md_theme_dark_onSurface = Color(0xFFE2E2E5)
val md_theme_dark_surfaceVariant = Color(0xFF42474E)
val md_theme_dark_onSurfaceVariant = Color(0xFFC2C7CE)
val md_theme_dark_outline = Color(0xFF8C9198)
val md_theme_dark_inverseOnSurface = Color(0xFF1A1C1E)
val md_theme_dark_inverseSurface = Color(0xFFE2E2E5)
val md_theme_dark_inversePrimary = Color(0xFF006397)
val md_theme_dark_shadow = Color(0xFF000000)
val md_theme_dark_surfaceTint = Color(0xFF93CCFF)
val md_theme_dark_outlineVariant = Color(0xFF42474E)
val md_theme_dark_scrim = Color(0xFF000000)

/// TODO(Ikhwan): upgrade compose, use darkColorSchema instead of darkColors
val DarkColors = darkColors(
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
//    primaryContainer = md_theme_dark_primaryContainer,
//    onPrimaryContainer = md_theme_dark_onPrimaryContainer,
    secondary = md_theme_dark_secondary,
    onSecondary = md_theme_dark_onSecondary,
//    secondaryContainer = md_theme_dark_secondaryContainer,
//    onSecondaryContainer = md_theme_dark_onSecondaryContainer,
//    tertiary = md_theme_dark_tertiary,
//    onTertiary = md_theme_dark_onTertiary,
//    tertiaryContainer = md_theme_dark_tertiaryContainer,
//    onTertiaryContainer = md_theme_dark_onTertiaryContainer,
    error = md_theme_dark_error,
//    errorContainer = md_theme_dark_errorContainer,
    onError = md_theme_dark_onError,
//    onErrorContainer = md_theme_dark_onErrorContainer,
    background = md_theme_dark_background,
    onBackground = md_theme_dark_onBackground,
    surface = md_theme_dark_surface,
    onSurface = md_theme_dark_onSurface,
//    surfaceVariant = md_theme_dark_surfaceVariant,
//    onSurfaceVariant = md_theme_dark_onSurfaceVariant,
//    outline = md_theme_dark_outline,
//    inverseOnSurface = md_theme_dark_inverseOnSurface,
//    inverseSurface = md_theme_dark_inverseSurface,
//    inversePrimary = md_theme_dark_inversePrimary,
//    surfaceTint = md_theme_dark_surfaceTint,
//    outlineVariant = md_theme_dark_outlineVariant,
//    scrim = md_theme_dark_scrim,
)