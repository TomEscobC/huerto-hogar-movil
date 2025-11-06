package com.huertohogar.ui.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.huertohogar.core.utils.validators.FormField
import com.huertohogar.core.utils.validators.FormValidator
import com.huertohogar.data.repositories.FirebaseAuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val authRepository: FirebaseAuthRepository
) : ViewModel() {
    
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
        // Validate form before attempting login
        validateForm()
        
        if (!_uiState.value.isValid) {
            return
        }
        
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, errorMessage = null)
            
            authRepository.signIn(_uiState.value.email, _uiState.value.password)
                .onSuccess { user ->
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        isLoggedIn = true,
                        errorMessage = null
                    )
                }
                .onFailure { exception ->
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        errorMessage = exception.message ?: "Login failed"
                    )
                }
        }
    }
    
    fun registerUser(displayName: String? = null) {
        // Validate form before attempting registration
        validateForm()
        
        if (!_uiState.value.isValid) {
            return
        }
        
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, errorMessage = null)
            
            authRepository.signUp(_uiState.value.email, _uiState.value.password, displayName)
                .onSuccess { user ->
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        isLoggedIn = true,
                        errorMessage = null
                    )
                }
                .onFailure { exception ->
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        errorMessage = exception.message ?: "Registration failed"
                    )
                }
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