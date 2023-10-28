package one.reevdev.bookshelf.core.data.remote.client

import kotlinx.coroutines.flow.Flow
import one.reevdev.bookshelf.core.data.remote.response.GetBookByIdResponse
import one.reevdev.bookshelf.core.data.remote.response.GetBooksResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("volumes")
    suspend fun getBooks(
        @Query("q") q: String
    ): GetBooksResponse

    @GET("volumes/{id}")
    suspend fun getBookById(
        @Path("id") id: String
    ): GetBookByIdResponse
}