package one.reevdev.bookshelf.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import one.reevdev.bookshelf.ui.navigation.Screen
import one.reevdev.bookshelf.ui.screen.detail.DetailScreen
import one.reevdev.bookshelf.ui.screen.home.HomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookshelfApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    Scaffold(
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home().route,
            modifier = Modifier
                .padding(innerPadding)
        ) {
            composable(route = Screen.Home().route) {
                HomeScreen(
                    onItemClick = { id, title ->
                        navController.navigate(
                            Screen.Detail(title = title).createRoute(bookId = id)
                        )
                    }
                )
            }
            composable(
                route = Screen.Detail().route,
                arguments = listOf(navArgument("bookId") { type = NavType.StringType })
            ) {
                val id = it.arguments?.getString("bookId").orEmpty()
                DetailScreen(
                    bookId = id,
                    onPreviewClick = {

                    }
                )
            }
        }
    }
}