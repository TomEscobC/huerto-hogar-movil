package com.huertohogar.core.utils.validators

class PasswordValidationRule : ValidationRule<String> {
    override fun validate(password: String): ValidationResult {
        return when {
            password.length < 6 -> {
                ValidationResult.Error("Password must be at least 6 characters")
            }
            !password.any { it.isDigit() } -> {
                ValidationResult.Error("Password must contain at least one number")
            }
            !password.any { it.isLetter() } -> {
                ValidationResult.Error("Password must contain at least one letter")
            }
            else -> {
                ValidationResult.Success(password)
            }
        }
    }
}