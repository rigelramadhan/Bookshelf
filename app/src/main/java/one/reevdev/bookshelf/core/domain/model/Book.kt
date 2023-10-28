package one.reevdev.bookshelf.core.domain.model

import one.reevdev.bookshelf.ui.utils.emptyString

data class Book(
    val id: String,
    val title: String,
    val author: List<String> = emptyList(),
    val publisher: String = emptyString(),
    val description: String,
    val pageCount: Int = 0,
    val categories: List<String> = emptyList(),
    val imageLink: String,
    val previewLink: String = emptyString(),
)
