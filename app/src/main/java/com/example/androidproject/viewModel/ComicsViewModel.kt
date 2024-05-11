package com.example.androidproject.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.androidproject.api.MarvelService
import com.example.androidproject.model.ComicsListState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.await

class ComicsViewModel(private val service: MarvelService) : ViewModel() {
    class Provider(private val service: MarvelService) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ComicsViewModel(service) as T
        }
    }

    private val _comicsListState = MutableLiveData<ComicsListState>()
    val comicsListState: LiveData<ComicsListState> get() = _comicsListState
    private val coroutineExceptionHandler =
        CoroutineExceptionHandler { _, throwable ->
            _comicsListState.postValue(ComicsListState.Error(throwable.message))
        }

    fun fetchComicsList() {
        _comicsListState.value = ComicsListState.Loading(true)
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            val response1 = service.getComics()
            val comicsList = response1.await().data.results
            withContext(Dispatchers.Main) {
                _comicsListState.setValue(
                    ComicsListState.Success(
                        comicsList
                    )
                )
            }
            _comicsListState.postValue(ComicsListState.Loading(false))
        }

    }
}