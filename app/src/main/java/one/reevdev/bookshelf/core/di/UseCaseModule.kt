package one.reevdev.bookshelf.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import one.reevdev.bookshelf.core.domain.repository.BookRepository
import one.reevdev.bookshelf.core.domain.usecase.BookInteractor
import one.reevdev.bookshelf.core.domain.usecase.BookUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideBookUseCase(bookRepository: BookRepository): BookUseCase {
        return BookInteractor(bookRepository)
    }
}