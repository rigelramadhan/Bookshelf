package one.reevdev.bookshelf.ui.navigation

import one.reevdev.bookshelf.ui.utils.BundleKeys

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Detail : Screen("detail/{${BundleKeys.BOOK_ID}}") {
        fun createRoute(bookId: String) = "detail/$bookId"
    }
}
