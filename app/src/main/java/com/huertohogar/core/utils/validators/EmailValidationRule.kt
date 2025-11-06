package com.huertohogar.core.utils.validators

import android.util.Patterns

class EmailValidationRule : ValidationRule<String> {
    override fun validate(email: String): ValidationResult {
        return if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            ValidationResult.Success(email)
        } else {
            ValidationResult.Error("Please enter a valid email address")
        }
    }
}