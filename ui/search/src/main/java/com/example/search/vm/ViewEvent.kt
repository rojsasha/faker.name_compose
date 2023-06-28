package com.example.search.vm

import com.example.base.base.vm.MviViewModel


internal sealed interface ViewEvent : MviViewModel.MviEvent {
    object Countries : ViewEvent
}
