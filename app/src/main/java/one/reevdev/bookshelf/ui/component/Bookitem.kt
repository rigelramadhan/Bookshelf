package one.reevdev.bookshelf.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import one.reevdev.bookshelf.R
import one.reevdev.bookshelf.ui.theme.BookshelfTheme

@Composable
fun BookItem(
    modifier: Modifier = Modifier,
    title: String,
    imageUrl: String,
) {
    Column(
        modifier = modifier
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(3 / 4f)
                .clip(RoundedCornerShape(24.dp))
                .background(MaterialTheme.colorScheme.surfaceVariant),
            model = imageUrl,
            contentScale = ContentScale.Crop,
            contentDescription = stringResource(id = R.string.book_image),
        )
        Text(
            modifier = Modifier
                .padding(8.dp),
            style = MaterialTheme.typography.bodyMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            text = title,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BookItemPreview() {
    BookshelfTheme {
        BookItem(title = "This is a Book: 2019 Edition", imageUrl = "")
    }
}