package one.reevdev.bookshelf.core.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import one.reevdev.bookshelf.core.domain.model.Book
import one.reevdev.bookshelf.core.domain.repository.BookRepository
import one.reevdev.bookshelf.core.domain.toDomain

class BookInteractor(private val repository: BookRepository) : BookUseCase {

    override fun getBooks(q: String): Flow<List<Book>> {
        return repository.getBooks(q).map {
            it.map { volumeInfo ->
                volumeInfo.toDomain()
            }
        }
    }

    override fun getBookDetail(id: String): Flow<Book> {
        return repository.getBookDetail(id).map {
            it.toDomain()
        }
    }
}