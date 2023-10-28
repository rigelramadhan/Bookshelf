package one.reevdev.bookshelf.ui.navigation

sealed class Screen(val route: String, val title: String) {
    class Home(title: String = "Bookshelf") : Screen(route = "home", title = title)
    class Detail(title: String = "Detail") : Screen(route = "detail/{bookId}", title = title) {
        fun createRoute(bookId: String) = "detail/$bookId"
    }
}
