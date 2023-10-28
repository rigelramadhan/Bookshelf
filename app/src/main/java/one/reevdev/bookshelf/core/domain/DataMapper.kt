package one.reevdev.bookshelf.core.domain

import one.reevdev.bookshelf.core.data.remote.response.GetBookByIdResponse
import one.reevdev.bookshelf.core.data.remote.response.ItemsItem
import one.reevdev.bookshelf.core.domain.model.Book

fun ItemsItem.toDomain(): Book = Book(
    id = id,
    title = volumeInfo.title,
    author = volumeInfo.authors.orEmpty(),
    publisher = volumeInfo.publisher.orEmpty(),
    description = volumeInfo.description.orEmpty(),
    pageCount = volumeInfo.pageCount,
    categories = volumeInfo.categories.orEmpty(),
    imageLink = volumeInfo.imageLinks.thumbnail,
    previewLink = volumeInfo.previewLink
)

fun GetBookByIdResponse.toDomain(): Book = Book(
    id = id,
    title = volumeInfo.title,
    author = volumeInfo.authors.orEmpty(),
    publisher = volumeInfo.publisher.orEmpty(),
    description = volumeInfo.description.orEmpty(),
    pageCount = volumeInfo.pageCount,
    categories = volumeInfo.categories.orEmpty(),
    imageLink = volumeInfo.imageLinks.thumbnail,
    previewLink = volumeInfo.previewLink
)