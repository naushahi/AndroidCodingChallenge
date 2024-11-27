package com.example.otchallenge.ui.bookslisting

import com.example.otchallenge.usecase.BooksUsecase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BooksPresenter<V: BooksMvpView> (
    private val mView: BooksMvpView,
    private val getBooksUseCase: BooksUsecase,
) {
    fun getBooks() {
        mView.showLoading(true)
        CoroutineScope(Dispatchers.IO).launch {
            val mBooks = getBooksUseCase.invoke()
            withContext(Dispatchers.Main) {
                mView.showLoading(false)
                mBooks.onSuccess { books ->
                    mView.displayBooks(books?.books, books?.listName)
                }.onFailure { error ->
                    mView.showError(error.message ?: "An unknown error occurred")
                }
            }
        }
    }

}