package com.example.search.vm

import androidx.paging.PagingData
import com.example.base.base.vm.MviViewModel
import com.example.model.Countries
import com.example.model.SearchModel

internal data class ViewState(
    val isLoading: Boolean = true,
    val hasError: Boolean = false,
//    val searchResult: PagingData<SearchModel> = PagingData.empty(),
    val countriesResult: List<Countries> = emptyList()
) : MviViewModel.MviViewState
