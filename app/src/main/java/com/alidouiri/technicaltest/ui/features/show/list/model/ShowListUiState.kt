package com.alidouiri.technicaltest.ui.features.show.list.model

import androidx.annotation.StringRes
import com.alidouiri.technicaltest.domain.model.Show

internal sealed class ShowListUiState {
    object Loading : ShowListUiState()
    data class Success(val showList: List<Show>) : ShowListUiState()
    data class Error(@StringRes val messageRes: Int) : ShowListUiState()
}