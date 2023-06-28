package com.example.data.posts.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.posts.remote.SearchDataSource
import com.example.data.posts.source.SearchSource
import com.example.model.DocumentsPage
import com.example.model.DocumentsPageModel
import com.example.model.SearchModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PostsRepositoryImpl @Inject constructor(
    private val documentsDataSource: SearchDataSource,
): PostsRepository {

    override fun searchPosts(query: String, countryId: Int?): Flow<PagingData<SearchModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { SearchSource(documentsDataSource, query, countryId) }
        ).flow
    }

}