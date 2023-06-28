package com.example.search.vm

import androidx.paging.PagingData
import com.example.base.base.vm.MviViewModel
import com.example.model.Countries
import com.example.model.DocumentsPage
import com.example.model.SearchModel

internal sealed interface ViewResult : MviViewModel.MviViewResult {

    object ErrorResult : ViewResult

    data class CountriesResult(
        val countriesResult: List<Countries>
    ) : ViewResult
}
