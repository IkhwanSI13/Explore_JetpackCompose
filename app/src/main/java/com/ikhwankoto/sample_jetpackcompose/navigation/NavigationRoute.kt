package com.ikhwankoto.sample_jetpackcompose.navigation

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessAlarm
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.PieChart
import androidx.compose.ui.graphics.vector.ImageVector

enum class NavigationRoute(
    val icon: ImageVector,
) {
    RouteHome(
        icon = Icons.Filled.PieChart,
    ),
    RouteSearch(
        icon = Icons.Filled.AttachMoney,
    ),
    RouteBill(
        icon = Icons.Filled.AccessAlarm,
    );

    companion object {
        fun fromRoute(route: String?): NavigationRoute {
            Log.e("Ikhwan", "trace navigation route: ${route}")
            Log.e(
                "Ikhwan",
                "trace navigation route?.substringBefore: ${route?.substringBefore("/")}"
            )
            return when (route?.substringBefore("/")) {
                RouteHome.name -> RouteHome
                RouteSearch.name -> RouteSearch
                RouteBill.name -> RouteBill
                null -> RouteHome
                else -> throw IllegalArgumentException("Route $route is not recognized.")
            }
        }
    }
}