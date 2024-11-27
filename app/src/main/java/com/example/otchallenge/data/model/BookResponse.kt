package com.example.otchallenge.data.model

import com.google.gson.annotations.SerializedName

data class BookResponse(
    val status: String,
    val copyright: String,
    @SerializedName("num_results")
    val numResults: Long,
    @SerializedName("last_modified")
    val lastModified: String,
    val results: BookResult,
)