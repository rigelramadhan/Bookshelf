package one.reevdev.bookshelf.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import one.reevdev.bookshelf.core.domain.model.Book
import one.reevdev.bookshelf.core.domain.usecase.BookUseCase
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val bookUseCase: BookUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<HomeUiState> =
        MutableStateFlow(HomeUiState.Loading())
    val uiState: StateFlow<HomeUiState> by lazy { _uiState }

    init {
        loadBooks("jazz+history")
    }

    fun loadBooks(q: String) {
        viewModelScope.launch {
            bookUseCase.getBooks(q)
                .catch { throwable ->
                    _uiState.update {
                        HomeUiState.Error(errorMessage = throwable.message.orEmpty())
                    }
                }
                .collect { books ->
                    _uiState.update {
                        HomeUiState.Success(books = books)
                    }
                }
        }
    }
}

sealed interface HomeUiState {
    val isLoading: Boolean
    val errorMessage: String?

    data class Success(
        override val isLoading: Boolean = false,
        override val errorMessage: String? = null,
        val books: List<Book>
    ) : HomeUiState

    data class Loading(
        override val isLoading: Boolean = true,
        override val errorMessage: String? = null
    ) : HomeUiState

    data class Error(
        override val isLoading: Boolean = false,
        override val errorMessage: String
    ) : HomeUiState
}