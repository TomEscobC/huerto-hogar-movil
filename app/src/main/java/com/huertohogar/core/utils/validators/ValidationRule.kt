package com.huertohogar.core.utils.validators

interface ValidationRule<T> {
    fun validate(input: T): ValidationResult
}

sealed class ValidationResult {
    data class Success<T>(val value: T) : ValidationResult()
    data class Error(val message: String) : ValidationResult()
}