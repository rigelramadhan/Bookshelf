package one.reevdev.bookshelf.ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import one.reevdev.bookshelf.R
import one.reevdev.bookshelf.core.domain.model.Book
import one.reevdev.bookshelf.ui.component.BookItem
import one.reevdev.bookshelf.ui.component.ErrorContent
import one.reevdev.bookshelf.ui.component.LoadingContent
import one.reevdev.bookshelf.ui.theme.BookshelfTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    navigateToDetail: (String) -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (uiState) {
        is HomeUiState.Loading -> {
            LoadingContent(
                modifier = modifier,
            )
        }

        is HomeUiState.Success -> {
            val data = (uiState as HomeUiState.Success).books
            HomeContent(
                modifier = modifier,
                bookList = data,
                navigateToDetail = navigateToDetail
            )
        }

        is HomeUiState.Error -> {
            ErrorContent(
                modifier = modifier,
                errorMessage = uiState.errorMessage
                    ?: stringResource(id = R.string.message_error_generic)
            )
        }
    }
}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    bookList: List<Book>,
    navigateToDetail: (String) -> Unit,
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Adaptive(148.dp),
        content = {
            items(items = bookList, key = { it.id }) {
                BookItem(
                    title = it.title,
                    imageUrl = it.imageLink,
                    navigateToDetail = { navigateToDetail(it.id) }
                )
            }
        },
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun HomeContentPreview() {
    val bookListDummy = listOf(
        Book(
            "1",
            "This is the Title 2019",
            "This is the description of the best book in the world",
            ""
        ),
        Book(
            "2",
            "This is the Title 2019",
            "This is the description of the best book in the world",
            ""
        ),
        Book(
            "3",
            "This is the Title 2019",
            "This is the description of the best book in the world",
            ""
        ),
        Book(
            "4",
            "This is the Title 2019",
            "This is the description of the best book in the world",
            ""
        ),
        Book(
            "5",
            "This is the Title 2019",
            "This is the description of the best book in the world",
            ""
        ),
        Book(
            "6",
            "This is the Title 2019",
            "This is the description of the best book in the world",
            ""
        ),
    )
    BookshelfTheme {
        HomeContent(bookList = bookListDummy) {}
    }
}