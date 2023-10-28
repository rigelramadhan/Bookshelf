package one.reevdev.bookshelf.ui.screen.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import one.reevdev.bookshelf.R
import one.reevdev.bookshelf.ui.screen.common.ErrorContent
import one.reevdev.bookshelf.ui.utils.emptyString

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel = hiltViewModel(),
    bookId: String,
    onPreviewClick: (String) -> Unit,
) {
    LaunchedEffect(bookId) {
        viewModel.getDetailBook(bookId)
    }
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (uiState) {
        is DetailUiState.Loading -> {

        }
        is DetailUiState.Success -> {
            val data = (uiState as DetailUiState.Success).book
            with(data) {
                DetailContent(
                    modifier = modifier,
                    title = title,
                    description = description,
                    imageLink = imageLink,
                    onPreviewClick = onPreviewClick,
                )
            }
        }
        is DetailUiState.Error -> {
            val message = remember {
                (uiState as DetailUiState.Error).errorMessage
            }
            ErrorContent(
                modifier = modifier,
                message = message,
            )
        }
    }
}

@Composable
fun DetailContent(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    imageLink: String,
    previewLink: String = emptyString(),
    onPreviewClick: (String) -> Unit,
) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(4/5f)
                .clip(MaterialTheme.shapes.large),
            contentScale = ContentScale.Crop,
            model = imageLink,
            contentDescription = stringResource(R.string.book_image)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            style = MaterialTheme.typography.headlineSmall,
            text = title
        )
        Spacer(modifier = Modifier.height(16.dp))
        if (description.isNotEmpty()) {
            Text(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .padding(16.dp),
                style = MaterialTheme.typography.bodyMedium,
                text = description
            )
        }
        if (previewLink.isNotEmpty()) {
            Button(onClick = { onPreviewClick(previewLink) }) {
                Text(text = stringResource(R.string.action_preview))
            }
        }
    }
}