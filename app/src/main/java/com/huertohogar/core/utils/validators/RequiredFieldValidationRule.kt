package com.huertohogar.core.utils.validators

class RequiredFieldValidationRule : ValidationRule<String> {
    override fun validate(text: String): ValidationResult {
        return if (text.isNotBlank()) {
            ValidationResult.Success(text)
        } else {
            ValidationResult.Error("This field is required")
        }
    }
}