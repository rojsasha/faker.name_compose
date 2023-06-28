package com.example.search.vm

import com.example.base.base.vm.MviViewModel
import com.example.model.SearchModel

internal interface ViewEffect : MviViewModel.MviSideEffect {
    data class OpenIngredientsSheet(val ingredients : List<SearchModel>) : ViewEffect
    object NoEffect: ViewEffect
}
