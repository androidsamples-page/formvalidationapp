package page.androidsamples.formvalidationapp

import androidx.core.util.PatternsCompat
import javax.inject.Inject

data class AuthFormData(
    val email: String,
    val password: String
)

sealed class ValidationResult
object ValidationSuccess : ValidationResult()
class ValidationError(val error: ValidationErrorType) : ValidationResult()


sealed class ValidationErrorType
object InvalidEmail : ValidationErrorType()
object PasswordMinLength : ValidationErrorType()
object PasswordLettersAndDigits : ValidationErrorType()

interface AuthValidator {
    fun validate(input: AuthFormData): ValidationResult
}

object EmailValidator : AuthValidator {

    override fun validate(input: AuthFormData): ValidationResult {
        if (PatternsCompat.EMAIL_ADDRESS.matcher(input.email).matches()) {
            return ValidationSuccess
        }

        return ValidationError(InvalidEmail)
    }
}

object PasswordValidator : AuthValidator {

    override fun validate(input: AuthFormData): ValidationResult {
        val password = input.password
        if (password.length < 6) {
            return ValidationError(PasswordMinLength)
        }
        val containsLetters = password.any { it.isLetter() }
        val containsDigits = password.any { it.isDigit() }
        if ((containsLetters && containsDigits).not()) {
            return ValidationError(PasswordLettersAndDigits)
        }
        return ValidationSuccess
    }
}

class AuthenticationValidationUseCase @Inject constructor() {
    private val validatorList = listOf(EmailValidator, PasswordValidator)
    fun validate(formData: AuthFormData): ValidationResult {
        validatorList.forEach { validator ->
            val result = validator.validate(formData)
            if (result is ValidationError) return result
        }
        return ValidationSuccess
    }
}