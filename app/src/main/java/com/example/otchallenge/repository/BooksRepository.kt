package com.example.otchallenge.repository

import com.example.otchallenge.data.model.BookResult

interface BooksRepository {

    suspend fun getBooksList(): Result<BookResult?>
}