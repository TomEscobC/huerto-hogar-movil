package com.huertohogar.ui.screens.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {
    
    private val _uiState = MutableStateFlow(DashboardUiState())
    val uiState: StateFlow<DashboardUiState> = _uiState
    
    init {
        loadGardenData()
    }
    
    private fun loadGardenData() {
        viewModelScope.launch {
            // Simulate loading garden data
            _uiState.value = _uiState.value.copy(isLoading = true)
            
            // Simulate network call
            kotlinx.coroutines.delay(800)
            
            _uiState.value = _uiState.value.copy(
                isLoading = false,
                gardenCount = 3  // Example: showing user has 3 gardens
            )
        }
    }
}

data class DashboardUiState(
    val isLoading: Boolean = false,
    val gardenCount: Int = 0,
    val errorMessage: String? = null
)