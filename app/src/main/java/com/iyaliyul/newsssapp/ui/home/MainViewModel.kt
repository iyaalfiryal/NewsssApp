package com.iyaliyul.newsssapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iyaliyul.newsssapp.data.model.NewsResponse
import com.iyaliyul.newsssapp.data.repository.NewsRepository
import com.iyaliyul.newsssapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: NewsRepository
): ViewModel() {

    private val _newsdata = MutableLiveData<Resource<NewsResponse>>()
    private val newsdata = _newsdata

    init {

    }

    fun fetchNews() = viewModelScope.launch {
        _newsdata.value = Resource.Loading
        repository.fetchNews().collect { news ->
            _newsdata.value = news
        }
    }
}