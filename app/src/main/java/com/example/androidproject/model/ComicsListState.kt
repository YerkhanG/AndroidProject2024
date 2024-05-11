package com.example.androidproject.model

sealed class ComicsListState {
    data class Loading(val isLoading: Boolean) : ComicsListState()
    data class Success(val items: List<Comics>) : ComicsListState()
    data class Error(val message: String? = null) : ComicsListState()
}