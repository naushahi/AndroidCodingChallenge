package com.example.otchallenge.repository

import com.example.otchallenge.data.model.BookResult
import com.example.otchallenge.data.remote.ApiService
import com.example.otchallenge.utils.Constants.API_KEY

class BooksRepositoryImpl(private val apiService: ApiService): BooksRepository {

    override suspend fun getBooksList(): Result<BookResult?> {
        return try{
            val response = apiService.getBooks(API_KEY, 0)
            if(response.isSuccessful) {
                val books = response.body()?.results
                Result.success(books)
            } else {
                Result.failure(Exception("Failed to fetch the data"))
            }
        } catch (e:Exception){
            Result.failure(e)
        }
    }
}