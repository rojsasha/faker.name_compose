package com.example.domain.usecases.search

import androidx.paging.PagingData
import com.example.data.posts.repository.PostsRepository
import com.example.domain.UseCase
import com.example.model.DocumentsPage
import com.example.model.SearchModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchPostUseCase @Inject constructor(
    private val postRepository: PostsRepository
) : UseCase<SearchPostUseCase.Params, Flow<PagingData<SearchModel>>>() {

    override fun execute(parameters: Params): Flow<PagingData<SearchModel>> {
        return postRepository.searchPosts(parameters.query, parameters.countryId)
    }

    class Params private constructor(
        val query: String,
        val countryId: Int?
    ) {

        companion object {
            fun create(
                query: String = "",
                countryId: Int = -1
            ): Params {
                return Params(query, countryId)
            }
        }
    }



}