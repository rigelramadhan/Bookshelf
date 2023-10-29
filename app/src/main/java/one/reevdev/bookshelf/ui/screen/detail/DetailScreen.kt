package one.reevdev.bookshelf.ui.screen.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import one.reevdev.bookshelf.R
import one.reevdev.bookshelf.ui.component.ErrorContent
import one.reevdev.bookshelf.ui.component.LoadingContent

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel = hiltViewModel(),
    bookId: String,
) {
    LaunchedEffect(key1 = bookId, block = {
        viewModel.loadBook(bookId)
    })
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (uiState) {
        is DetailUiState.Loading -> {
            LoadingContent(
                modifier = modifier
            )
        }

        is DetailUiState.Success -> {
            val data = (uiState as DetailUiState.Success).book
            DetailContent(
                modifier = modifier,
                title = data.title,
                imageUrl = data.imageLink
            )
        }

        is DetailUiState.Error -> {
            val message = uiState.errorMessage
            ErrorContent(
                errorMessage = message ?: stringResource(id = R.string.message_error_generic)
            )
        }
    }
}

@Composable
fun DetailContent(
    modifier: Modifier = Modifier,
    title: String,
    imageUrl: String,
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
    ) {
        AsyncImage(
            modifier = Modifier
                .aspectRatio(3 / 4f)
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(24.dp)),
            model = imageUrl,
            contentScale = ContentScale.Crop,
            contentDescription = stringResource(R.string.description_book_image),
        )
        Text(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            style = MaterialTheme.typography.headlineMedium,
            text = title
        )
    }
}