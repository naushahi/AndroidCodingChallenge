package com.example.otchallenge.data.remote

import com.example.otchallenge.data.model.BookResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("lists/current/hardcover-fiction.json")
   suspend fun getBooks(
        @Query("api-key") apiKey: String,
        @Query("offset") offset: Int,
        ): Response<BookResponse>
}