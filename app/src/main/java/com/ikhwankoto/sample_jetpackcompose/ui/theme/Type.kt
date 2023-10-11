package com.ikhwankoto.sample_jetpackcompose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ikhwankoto.sample_jetpackcompose.R

private val Balsamiq = FontFamily(
    Font(R.font.balsamiq_sans_regular),
    Font(R.font.balsamiq_sans_bold, FontWeight.W700),
    Font(R.font.balsamiq_sans_italic, style = FontStyle.Italic),
    Font(R.font.balsamiq_sans_bold_italic, FontWeight.W700, style = FontStyle.Italic)
)

// TODO(Ikhwan): update compose version
// Set of Material typography styles to start with
val MyComposeTypography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    h4 = TextStyle(
        fontFamily = Balsamiq,
        fontWeight = FontWeight.W700,
        fontSize = 30.sp
    ),
    h5 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W600,
        fontSize = 24.sp
    ),
    h6 = TextStyle(
        fontFamily = Balsamiq,
        fontWeight = FontWeight.W700,
        fontStyle = FontStyle.Italic,
        fontSize = 20.sp
    ),
    button = TextStyle(
        fontFamily = Balsamiq,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    /* Other default text styles to override
        caption = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        ),
        subtitle1 = TextStyle(
            fontFamily = Montserrat,
            fontWeight = FontWeight.W600,
            fontSize = 16.sp
        ),
        subtitle2 = TextStyle(
            fontFamily = Montserrat,
            fontWeight = FontWeight.W500,
            fontSize = 14.sp
        ),
        body2 = TextStyle(
            fontFamily = Montserrat,
            fontSize = 14.sp
        ),
        overline = TextStyle(
            fontFamily = Montserrat,
            fontWeight = FontWeight.W500,
            fontSize = 12.sp
        )
    */
)