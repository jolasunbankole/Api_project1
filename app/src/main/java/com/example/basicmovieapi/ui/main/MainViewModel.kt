package com.example.basicmovieapi.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basicmovieapi.server.connection.MovieApi
import com.example.basicmovieapi.server.connection.MovieContentResponse
import kotlinx.coroutines.launch

enum class MovieApiStatus {LOADING, ERROR, DONE}

class MainViewModel : ViewModel(){

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<MovieApiStatus>()
    // The external immutable LiveData for the request status
    val status: LiveData<MovieApiStatus> = _status

    private val _content = MutableLiveData<List<MovieContentResponse>>()
    val content: LiveData<List<MovieContentResponse>> = _content

    init {
        getMoviesContent()
    }

    private fun getMoviesContent(){
        viewModelScope.launch {
            _status.value = MovieApiStatus.LOADING
            try {
                _content.value = MovieApi.retrofitService.getMovies()
                _status.value = MovieApiStatus.DONE
            }catch (e: Exception){
                _status.value = MovieApiStatus.ERROR
                _content.value = listOf()


            }
        }
    }
}
