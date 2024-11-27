package com.example.otchallenge.ui.bookslisting

import com.example.otchallenge.data.model.Book

interface BooksMvpView {
    fun showLoading(isLoading: Boolean)
    fun displayBooks(mBooks: List<Book>?,title: String?)
    fun showError(errorMessage: String)
}