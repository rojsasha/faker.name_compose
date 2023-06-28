package com.example.data.posts.repository

import androidx.paging.PagingData
import com.example.model.SearchModel
import kotlinx.coroutines.flow.Flow

interface PostsRepository {
    fun searchPosts(
        query: String,
        countryId: Int?
    ): Flow<PagingData<SearchModel>>
}