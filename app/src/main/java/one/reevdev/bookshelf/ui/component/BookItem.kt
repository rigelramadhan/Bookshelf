package one.reevdev.bookshelf.ui.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import one.reevdev.bookshelf.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BookItem(
    modifier: Modifier = Modifier,
    imageUrl: String,
    title: String,
    description: String,
    onHoldActive: Boolean = false,
    onItemClick: () -> Unit,
    onItemLongClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .combinedClickable(
                onClick = onItemClick,
                onLongClick = onItemLongClick
            )
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(4/5f),
            model = imageUrl,
            contentScale = ContentScale.Crop,
            contentDescription = stringResource(R.string.book_image)
        )
        if (onHoldActive) {
            TitleAndDescription(
                modifier = Modifier.align(Alignment.BottomStart),
                title = title,
                description = description
            )
        }
    }
}

@Composable
fun TitleAndDescription(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = title
        )
        Text(
            text = description
        )
    }
}