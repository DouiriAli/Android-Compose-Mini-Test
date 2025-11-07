package com.alidouiri.technicaltest.ui.features.show.list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alidouiri.technicaltest.R
import com.alidouiri.technicaltest.domain.usecase.ShowListUseCase
import com.alidouiri.technicaltest.ui.features.show.list.model.ShowListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class ShowListViewModel @Inject constructor(
    private val showListUseCase: ShowListUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<ShowListUiState>(ShowListUiState.Loading)
    val uiState: StateFlow<ShowListUiState> = _uiState

    init {
        loadShows()
    }

    private fun loadShows() {
        viewModelScope.launch {
            try {
                _uiState.value = ShowListUiState.Loading
                val showList = showListUseCase()
                _uiState.value = ShowListUiState.Success(showList)
            } catch (e: Exception) {
                Log.e(TAG, "An error has occurred while loading show list: ${e.message}")
                _uiState.value = ShowListUiState.Error(R.string.error_message)
            }
        }
    }
}

private val TAG = ShowListViewModel::class.java.simpleName