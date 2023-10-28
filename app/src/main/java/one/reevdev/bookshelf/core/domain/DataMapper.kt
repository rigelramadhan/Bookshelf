package one.reevdev.bookshelf.core.domain

import one.reevdev.bookshelf.core.data.remote.response.GetBookByIdResponse
import one.reevdev.bookshelf.core.data.remote.response.ItemsItem
import one.reevdev.bookshelf.core.domain.model.Book

fun ItemsItem.toDomain(): Book = Book(
    id = id,
    title = volumeInfo.title,
    description = volumeInfo.description.orEmpty(),
    imageLink = volumeInfo.imageLinks.thumbnail,
)

fun GetBookByIdResponse.toDomain(): Book = Book(
    id = id,
    title = volumeInfo.title,
    description = volumeInfo.description.orEmpty(),
    imageLink = volumeInfo.imageLinks.thumbnail,
)