package com.ikhwankoto.sample_jetpackcompose.animation

import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.TabPosition
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ikhwankoto.sample_jetpackcompose.ui.theme.*

private enum class TabPage {
    Home, Work
}

@Preview(name = "Animation Tab")
@Composable
fun PreviewAnimationTab() {
    Sample_JetpackComposeTheme {
        AnimationTab()
    }
}

@Composable
fun AnimationTab() {
    // The currently selected tab.
    var tabPage by remember { mutableStateOf(TabPage.Home) }

    // The background color. The value is changed by the current tab.
    val backgroundColor by animateColorAsState(if (tabPage == TabPage.Home) Purple200 else Teal200)

    TabRow(
        selectedTabIndex = tabPage.ordinal,
        backgroundColor = backgroundColor,
        indicator = { tabPositions ->
            HomeTabIndicator(tabPositions, tabPage)
        }
    ) {
        HomeTab(
            icon = Icons.Default.Home,
            title = "home",
            onClick = { tabPage = TabPage.Home }
        )
        HomeTab(
            icon = Icons.Default.AccountBox,
            title = "work",
            onClick = { tabPage = TabPage.Work }
        )
    }
}

@Composable
private fun HomeTabIndicator(
    tabPositions: List<TabPosition>,
    tabPage: TabPage
) {
    val transition = updateTransition(
        tabPage,
        label = "Tab indicator"
    )
    val indicatorLeft by transition.animateDp(
        transitionSpec = {
            if (TabPage.Home isTransitioningTo TabPage.Work) {
                // Indicator moves to the right.
                // Low stiffness spring for the left edge so it moves slower than the right edge.
                spring(stiffness = Spring.StiffnessVeryLow)
            } else {
                // Indicator moves to the left.
                // Medium stiffness spring for the left edge so it moves faster than the right edge.
                spring(stiffness = Spring.StiffnessMedium)
            }
        },
        label = "Indicator left"
    ) { page ->
        tabPositions[page.ordinal].left
    }
    val indicatorRight by transition.animateDp(
        transitionSpec = {
            if (TabPage.Home isTransitioningTo TabPage.Work) {
                // Indicator moves to the right
                // Medium stiffness spring for the right edge so it moves faster than the left edge.
                spring(stiffness = Spring.StiffnessMedium)
            } else {
                // Indicator moves to the left.
                // Low stiffness spring for the right edge so it moves slower than the left edge.
                spring(stiffness = Spring.StiffnessVeryLow)
            }
        },
        label = "Indicator right"
    ) { page ->
        tabPositions[page.ordinal].right
    }
    val color by transition.animateColor(
        label = "Border color"
    ) { page ->
        if (page == TabPage.Home) Purple700 else Green800
    }
    Box(
        Modifier
            .fillMaxSize()
            .wrapContentSize(align = Alignment.BottomStart)
            .offset(x = indicatorLeft)
            .width(indicatorRight - indicatorLeft)
            .padding(4.dp)
            .fillMaxSize()
            .border(
                BorderStroke(2.dp, color),
                RoundedCornerShape(4.dp)
            )
    )
}

@Composable
private fun HomeTab(
    icon: ImageVector,
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clickable(onClick = onClick)
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = title)
    }
}
