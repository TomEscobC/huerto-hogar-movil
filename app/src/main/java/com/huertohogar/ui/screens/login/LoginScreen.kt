package com.huertohogar.ui.screens.login

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.huertohogar.core.navigation.Screen
import com.huertohogar.ui.components.forms.ValidatedInputField

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    
    LaunchedEffect(uiState.isLoggedIn) {
        if (uiState.isLoggedIn) {
            navController.navigate(Screen.Dashboard.route) {
                popUpTo(Screen.Login.route) { inclusive = true }
            }
        }
    }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Huerto Hogar",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        
        ValidatedInputField(
            value = uiState.email,
            onValueChange = { viewModel.updateEmail(it) },
            label = "Email",
            error = uiState.emailError,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        ValidatedInputField(
            value = uiState.password,
            onValueChange = { viewModel.updatePassword(it) },
            label = "Password",
            error = uiState.passwordError,
            isPassword = true
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        Button(
            onClick = { 
                viewModel.loginUser()
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = uiState.isValid && !uiState.isLoading
        ) {
            if (uiState.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(24.dp),
                    strokeWidth = 2.dp
                )
            } else {
                Text("Login")
            }
        }
        
        if (uiState.errorMessage != null) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = uiState.errorMessage,
                color = MaterialTheme.colorScheme.error
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = if (uiState.isValid) "Form is valid" else "Please fix validation errors",
            color = if (uiState.isValid) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error,
            style = MaterialTheme.typography.bodySmall
        )
    }
}