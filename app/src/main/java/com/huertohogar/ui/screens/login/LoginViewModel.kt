package com.huertohogar.ui.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.huertohogar.core.utils.validators.FormField
import com.huertohogar.core.utils.validators.FormValidator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState
    
    private val validator = FormValidator()
    
    fun updateEmail(email: String) {
        _uiState.value = _uiState.value.copy(email = email)
        validateForm()
    }
    
    fun updatePassword(password: String) {
        _uiState.value = _uiState.value.copy(password = password)
        validateForm()
    }
    
    private fun validateForm() {
        val errors = validator.validateLoginForm(
            _uiState.value.email,
            _uiState.value.password
        )
        
        _uiState.value = _uiState.value.copy(
            emailError = errors[FormField.EMAIL],
            passwordError = errors[FormField.PASSWORD],
            isValid = errors.isEmpty()
        )
    }
    
    fun loginUser() {
        validateForm()
        
        if (!_uiState.value.isValid) {
            return
        }
        
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, errorMessage = null)
            
            kotlinx.coroutines.delay(1000)
            
            _uiState.value = _uiState.value.copy(
                isLoading = false,
                isLoggedIn = true
            )
        }
    }
}

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val emailError: String? = null,
    val passwordError: String? = null,
    val isLoading: Boolean = false,
    val isLoggedIn: Boolean = false,
    val isValid: Boolean = false,
    val errorMessage: String? = null
)