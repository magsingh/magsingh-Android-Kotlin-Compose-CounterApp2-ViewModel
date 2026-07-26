package com.example.compose_counterapp

import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class CounterViewModel : ViewModel() {
    var count by mutableIntStateOf(0)
        private set //The UI should read the count.
                    //Only the ViewModel should change it.
                    //So make the setter private.
                    //Now the UI can do: println(viewModel.count)
                    //but cannot do: viewModel.count = 100
    fun increment() {
        count++
    }
    fun decrement() {
        count--
    }
    fun reset() {
        count = 0
    }
}