package com.example.data.posts.remote

import com.example.data.remote.FakerApi

class SearchDataSourceImpl(
    private val api: FakerApi
) : SearchDataSource {
    override suspend fun searchDocuments(query: String, countryId: Int?, offset: Int) =
        api.searchDocuments(query, countryId, offset)
}
