package one.reevdev.bookshelf.ui.screen.home

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import one.reevdev.bookshelf.core.domain.model.Book
import one.reevdev.bookshelf.ui.component.BookItem
import one.reevdev.bookshelf.ui.screen.common.ErrorContent
import one.reevdev.bookshelf.ui.utils.emptyString

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    onItemClick: (id: String, title: String) -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    var onHoldActiveItems = remember { emptyString() }

    when (uiState) {
        is HomeUiState.Loading -> {

        }

        is HomeUiState.Success -> {
            val data = remember {
                (uiState as HomeUiState.Success).bookList
            }
            HomeContent(
                modifier = modifier,
                bookList = data,
                onItemClick = onItemClick,
                onLongItemClick = {
                    onHoldActiveItems = it
                },
                onHoldActiveItem = onHoldActiveItems
            )
        }

        is HomeUiState.Error -> {
            val message = remember {
                (uiState as HomeUiState.Error).errorMessage
            }
            ErrorContent(
                modifier = modifier,
                message = message
            )
        }
    }
}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    bookList: List<Book>,
    onItemClick: (id: String, title: String) -> Unit,
    onLongItemClick: (id: String) -> Unit,
    onHoldActiveItem: String,
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Adaptive(180.dp),
        content = {
            items(items = bookList, key = { it.id }) {
                BookItem(
                    imageUrl = it.imageLink,
                    title = it.title,
                    description = it.description,
                    onItemClick = { onItemClick(it.id, it.title) },
                    onItemLongClick = { onLongItemClick(it.id) },
                    onHoldActive = onHoldActiveItem == it.id
                )
            }
        })
}