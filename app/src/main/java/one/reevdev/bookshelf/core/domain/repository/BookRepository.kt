package one.reevdev.bookshelf.core.domain.repository

import kotlinx.coroutines.flow.Flow
import one.reevdev.bookshelf.core.data.remote.response.GetBookByIdResponse
import one.reevdev.bookshelf.core.data.remote.response.ItemsItem
import one.reevdev.bookshelf.core.data.remote.response.VolumeInfo

interface BookRepository {
    fun getBooks(q: String): Flow<List<ItemsItem>>
    fun getBookDetail(id: String): Flow<GetBookByIdResponse>
}