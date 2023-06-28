package com.example.data.posts.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.posts.remote.SearchDataSource
import com.example.model.DocumentsPageModel
import com.example.model.SearchModel
import com.example.model.toUIModel
import javax.inject.Inject

private const val INITIAL_INDEX_PAGE = 1

class SearchSource @Inject constructor(
    private val documentsDataSource: SearchDataSource,
    private val query: String,
    private val countryId: Int?
) : PagingSource<Int, SearchModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SearchModel> {
        return try {
            val page = params.key ?: INITIAL_INDEX_PAGE
            val searchItem = documentsDataSource.searchDocuments(
                offset = page,
                query = query,
                countryId = countryId
            )
            LoadResult.Page(
                data = searchItem?.data?.map {
                    it
                } ?: emptyList(),
                prevKey = if (page == INITIAL_INDEX_PAGE) null else page - 1,
                nextKey = if (searchItem?.data?.isEmpty() == true) null else page.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, SearchModel>): Int? {
        return null
    }
}