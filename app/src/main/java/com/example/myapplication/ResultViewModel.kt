package com.example.myapplication

import androidx.lifecycle.ViewModel

data class ResultState(
    val result: Double? = null
)


class ResultViewModel : ViewModel() {
    companion object {
        var instance: ResultViewModel = ResultViewModel()

        fun getResultViewModel(): ResultViewModel {
            return instance
        }
    }

    var result: ResultState? = null

    fun loadResult (num: Double?) {
        result = ResultState(num)
    }

    fun retrieveResult () : Double {
        return result?.result ?: 0.0
    }
}