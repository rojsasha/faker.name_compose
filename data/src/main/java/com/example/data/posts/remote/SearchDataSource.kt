package com.example.data.posts.remote

import com.example.model.Search

interface SearchDataSource {
    suspend fun searchDocuments(
        query: String,
        countryId: Int?,
        offset: Int
    ): Search?
}