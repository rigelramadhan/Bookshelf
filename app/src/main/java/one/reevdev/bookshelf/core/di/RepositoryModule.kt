package one.reevdev.bookshelf.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import one.reevdev.bookshelf.core.data.remote.client.ApiService
import one.reevdev.bookshelf.core.data.repository.BookRepositoryImpl
import one.reevdev.bookshelf.core.domain.repository.BookRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideBookRepository(apiService: ApiService): BookRepository {
        return BookRepositoryImpl(apiService)
    }
}