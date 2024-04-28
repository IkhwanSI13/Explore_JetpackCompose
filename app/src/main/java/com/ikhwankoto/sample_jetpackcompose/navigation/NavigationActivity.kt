package com.ikhwankoto.sample_jetpackcompose.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.ikhwankoto.sample_jetpackcompose.navigation.data.BillData
import com.ikhwankoto.sample_jetpackcompose.navigation.screens.BillDetailScreen
import com.ikhwankoto.sample_jetpackcompose.navigation.screens.BillsScreen
import com.ikhwankoto.sample_jetpackcompose.navigation.screens.HomeScreen
import com.ikhwankoto.sample_jetpackcompose.navigation.screens.SearchScreen

class NavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationContent()
        }
    }
}

@Composable
fun NavigationContent() {
    val allScreens = NavigationRoute.values().toList()
    val navController = rememberNavController()
    val backstackEntry = navController.currentBackStackEntryAsState()
    val currentScreen = NavigationRoute.fromRoute(backstackEntry.value?.destination?.route)

    Scaffold(
//        topBar = {
//            RallyTabRow(
//                allScreens = allScreens,
//                onTabSelected = { screen ->
//                    navController.navigate(screen.name)
//                },
//                currentScreen = currentScreen
//            )
//        }
    ) { innerPadding ->
        MyNavHost(navController, modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun MyNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = NavigationRoute.RouteHome.name,
        modifier = modifier
    ) {
        composable(NavigationRoute.RouteHome.name) {
            HomeScreen(
                onClickToSearch = { navController.navigate(NavigationRoute.RouteSearch.name) },
                onClickToBill = { navController.navigate(NavigationRoute.RouteBill.name) },
            )
        }
        composable(NavigationRoute.RouteSearch.name) {
            SearchScreen(
                onClickToHome = { navController.navigate(NavigationRoute.RouteHome.name) },
            )
        }
        composable(NavigationRoute.RouteBill.name) {
            BillsScreen(
                bills = BillData.bills,
                onClickToHome = { navController.navigate(NavigationRoute.RouteHome.name) },
                onClickToDetail = { bill ->
                    navController.navigate(
                        "${NavigationRoute.RouteBill.name}/${bill.name}"
                    )
                })
        }
//        val accountsName = NavigationRoute.RouteBill.name
        composable(
            route = "${NavigationRoute.RouteBill.name}/{value}",
            arguments = listOf(
                navArgument("value") {
                    type = NavType.StringType
                }
            ),
            deepLinks = listOf(
                navDeepLink {
                    /**
                     * Manifest:
                     * <data android:scheme="https" android:host="yukngoding.id" />
                     * Use this command:
                     * adb shell am start -d "https://yukngoding.id/RouteBill/Name%203" -a android.intent.action.VIEW
                     * */
                    // uriPattern = "https://yukngoding.id/${NavigationRoute.RouteBill.name}/{value}"
                    /**
                     * Manifest:
                     * <data android:scheme="yukngoding" android:host="routebill" />
                     * Use this command:
                     * adb shell am start -d "yukngoding://routebill/Name%203" -a android.intent.action.VIEW
                     * */
                    uriPattern = "yukngoding://${NavigationRoute.RouteBill.name}/{value}"
                }
            ),
        ) { entry ->
            val value = entry.arguments?.getString("value")
            val bill = BillData.getBill(value)
            BillDetailScreen(
                bill = bill,
                onClickToBill = {
                    navController.navigateUp()

                    /// Return with value (https://medium.com/@desilio/navigate-back-with-result-with-jetpack-compose-e91e6a6847c9)
                    // navController.currentBackStackEntry
                    //    ?.savedStateHandle
                    //    ?.set("book", Book(title = text))
                    // navController.popBackStack()
                    //
                    // navBackResult.savedStateHandle.get<Book>("book")
                })
        }
    }
}

//private fun navigateToSingleAccount(navController: NavHostController, accountName: String) {
//    navController.navigate("${Accounts.name}/$accountName")
//}
