package com.example.search.vm

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.base.base.vm.MviViewModel
import com.example.base.result.Results
import com.example.base.result.data
import com.example.domain.usecases.counties.CountriesListUseCase
import com.example.domain.usecases.search.SearchPostUseCase
import com.example.model.Countries
import com.example.search.vm.ViewEvent.*
import com.example.search.vm.ViewResult.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

const val QUERY_KEY = "query"
const val COUNTRY_KEY = "country_key"

@HiltViewModel
internal class SearchViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val searchRecipesUseCase: SearchPostUseCase,
    private val countriesUseCase: CountriesListUseCase
) : MviViewModel<ViewEvent, ViewResult, ViewState, ViewEffect>(ViewState()) {

    private val _countriesList = MutableStateFlow<List<Countries>>(emptyList())
    val countriesList: StateFlow<List<Countries>> = _countriesList

    init {
        viewModelScope.launch {
            _countriesList.emit(countriesUseCase(Unit).data ?: emptyList())
        }
    }

    override fun ViewResult.reduce(state: ViewState): ViewState {
        return when (this) {
            is ErrorResult -> state.copy(hasError = true)
            is CountriesResult -> state.copy(
                hasError = false,
                isLoading = false,
                countriesResult = countriesResult
            )
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private fun Flow<Unit>.toCountriesResult(): Flow<ViewResult> {
        return mapLatest { countriesUseCase(Unit) }
            .map {
                if (it is Results.Success) {
                    CountriesResult(countriesResult = it.data)
                } else {
                    ErrorResult
                }
                ErrorResult
            }
    }

    override fun Flow<ViewEvent>.toResults(): Flow<ViewResult> {
        return merge(
            filterIsInstance<Unit>().toCountriesResult()
        )
    }
}