package com.example.otchallenge.usecase

import com.example.otchallenge.data.model.BookResult
import com.example.otchallenge.repository.BooksRepository
import javax.inject.Inject

class BooksUsecase @Inject constructor(private val booksRepository: BooksRepository) {
    suspend operator fun invoke(): Result<BookResult?> {
        return booksRepository.getBooksList()
    }
}