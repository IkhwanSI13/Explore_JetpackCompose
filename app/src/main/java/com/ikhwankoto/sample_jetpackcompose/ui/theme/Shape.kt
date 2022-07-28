package com.ikhwankoto.sample_jetpackcompose.ui.theme

import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val MyComposeShapes = Shapes(
    small = CutCornerShape(bottomEnd = 8.dp),
    medium = RoundedCornerShape(18.dp),
    large = RoundedCornerShape(0.dp)
)