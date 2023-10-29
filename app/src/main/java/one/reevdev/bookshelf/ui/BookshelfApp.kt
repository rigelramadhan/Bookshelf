package one.reevdev.bookshelf.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import one.reevdev.bookshelf.R
import one.reevdev.bookshelf.ui.navigation.Screen
import one.reevdev.bookshelf.ui.screen.detail.DetailScreen
import one.reevdev.bookshelf.ui.screen.home.HomeScreen
import one.reevdev.bookshelf.ui.utils.BundleKeys
import one.reevdev.bookshelf.ui.utils.emptyString

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookshelfApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = stringResource(id = R.string.app_name),
                        color = MaterialTheme.colorScheme.onPrimary,
                        textAlign = TextAlign.Center
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    modifier = Modifier
                        .padding(innerPadding),
                    navigateToDetail = {
                        navController.navigate(route = Screen.Detail.createRoute(it))
                    }
                )
            }
            composable(
                route = Screen.Detail.route,
                arguments = listOf(navArgument(BundleKeys.BOOK_ID) { type = NavType.StringType })
            ) {
                val id = it.arguments?.getString(BundleKeys.BOOK_ID) ?: emptyString()
                DetailScreen(
                    modifier = Modifier
                        .padding(innerPadding),
                    bookId = id
                )
            }
        }
    }
}