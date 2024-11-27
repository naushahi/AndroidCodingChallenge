package com.example.otchallenge.data.model

import com.google.gson.annotations.SerializedName

data class Book (
    val rank: Long,
    @SerializedName("rank_last_week")
    val rankLastWeek: Long,
    @SerializedName("weeks_on_list")
    val weeksOnList: Long,
    val asterisk: Long,
    val dagger: Long,
    @SerializedName("primary_isbn10")
    val primaryIsbn10: String,
    @SerializedName("primary_isbn13")
    val primaryIsbn13: String,
    val publisher: String,
    val description: String,
    val price: String,
    val title: String,
    val author: String,
    val contributor: String,
    @SerializedName("contributor_note")
    val contributorNote: String,
    @SerializedName("book_image")
    val bookImage: String,
    @SerializedName("book_image_width")
    val bookImageWidth: Long,
    @SerializedName("book_image_height")
    val bookImageHeight: Long,
    @SerializedName("amazon_product_url")
    val amazonProductUrl: String,
    @SerializedName("age_group")
    val ageGroup: String,
    @SerializedName("book_review_link")
    val bookReviewLink: String,
    @SerializedName("first_chapter_link")
    val firstChapterLink: String,
    @SerializedName("sunday_review_link")
    val sundayReviewLink: String,
    @SerializedName("article_chapter_link")
    val articleChapterLink: String,
    val isbns: List<Isbn>,
    @SerializedName("buy_links")
    val buyLinks: List<BuyLink>,
    @SerializedName("book_uri")
    val bookUri: String,
)
