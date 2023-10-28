package one.reevdev.bookshelf.core.domain.usecase

import kotlinx.coroutines.flow.Flow
import one.reevdev.bookshelf.core.domain.model.Book

interface BookUseCase {

    fun getBooks(q: String): Flow<List<Book>>

    fun getBookDetail(id: String): Flow<Book>
}