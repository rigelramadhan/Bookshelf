package one.reevdev.bookshelf.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import one.reevdev.bookshelf.core.domain.model.Book
import one.reevdev.bookshelf.core.domain.usecase.BookUseCase
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val bookUseCase: BookUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<DetailUiState> =
        MutableStateFlow(DetailUiState.Loading())
    val uiState: StateFlow<DetailUiState> by lazy { _uiState }

    fun loadBook(bookId: String) {
        viewModelScope.launch {
            _uiState.update { DetailUiState.Loading() }
            bookUseCase.getBookDetail(bookId)
                .catch { throwable ->
                    _uiState.update {
                        DetailUiState.Error(errorMessage = throwable.message.orEmpty())
                    }
                }
                .collect { book ->
                    _uiState.update {
                        DetailUiState.Success(book = book)
                    }
                }
        }
    }
}

sealed interface DetailUiState {
    val isLoading: Boolean
    val errorMessage: String?

    data class Success(
        override val isLoading: Boolean = false,
        override val errorMessage: String? = null,
        val book: Book
    ) : DetailUiState

    data class Loading(
        override val isLoading: Boolean = true,
        override val errorMessage: String? = null,
    ) : DetailUiState

    data class Error(
        override val isLoading: Boolean = false,
        override val errorMessage: String?
    ) : DetailUiState
}