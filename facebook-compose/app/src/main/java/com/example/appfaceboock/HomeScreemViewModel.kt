package com.example.appfaceboock

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class  HomeScreenState{

    object Loading : HomeScreenState()
    data class Loaded(
        val avatarUrl: String
    ): HomeScreenState()

    object SignInRequired: HomeScreenState()
}

class HomeScreemViewModel : ViewModel() {

    private val mutableState = MutableStateFlow<HomeScreenState>(
        HomeScreenState.Loading
    )

    val state = mutableState.asStateFlow()

    init{
        viewModelScope.launch {
            // check for user sined up
            mutableState.emit(
                HomeScreenState.SignInRequired
            )
        }
    }
}


