package one.reevdev.bookshelf.core.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import one.reevdev.bookshelf.core.data.remote.client.ApiService
import one.reevdev.bookshelf.core.data.remote.response.GetBookByIdResponse
import one.reevdev.bookshelf.core.data.remote.response.ItemsItem
import one.reevdev.bookshelf.core.domain.repository.BookRepository
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : BookRepository {
    override fun getBooks(q: String): Flow<List<ItemsItem>> = flow {
        emit(apiService.getBooks(q).items)
    }

    override fun getBookDetail(id: String): Flow<GetBookByIdResponse> = flow {
        emit(apiService.getBookById(id))
    }
}