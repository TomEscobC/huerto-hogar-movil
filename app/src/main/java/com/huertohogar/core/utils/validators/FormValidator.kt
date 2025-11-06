package com.huertohogar.core.utils.validators

class FormValidator {
    fun validateLoginForm(email: String, password: String): Map<FormField, String?> {
        val errors = mutableMapOf<FormField, String?>()
        
        val emailResult = validateWithRules(
            email,
            listOf(
                RequiredFieldValidationRule(),
                EmailValidationRule()
            )
        )
        if (emailResult != null) errors[FormField.EMAIL] = emailResult
        
        val passwordResult = validateWithRules(
            password,
            listOf(
                RequiredFieldValidationRule(),
                PasswordValidationRule()
            )
        )
        if (passwordResult != null) errors[FormField.PASSWORD] = passwordResult
        
        return errors
    }
    
    private fun <T> validateWithRules(
        input: T,
        rules: List<ValidationRule<T>>
    ): String? {
        for (rule in rules) {
            val result = rule.validate(input)
            if (result is ValidationResult.Error) {
                return result.message
            }
        }
        return null
    }
}

enum class FormField {
    EMAIL,
    PASSWORD
}