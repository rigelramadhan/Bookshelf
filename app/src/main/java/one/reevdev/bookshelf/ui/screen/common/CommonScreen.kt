package one.reevdev.bookshelf.ui.screen.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import one.reevdev.bookshelf.R

@Composable
fun ErrorContent(
    modifier: Modifier = Modifier,
    message: String? = null,
) {
    Row(
        modifier = modifier
            .padding(36.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Rounded.Warning,
            contentDescription = stringResource(R.string.description_error_icon)
        )
        Text(
            modifier = Modifier
                .padding(start = 8.dp),
            text = message ?: stringResource(R.string.message_error_generic)
        )
    }
}