package page.androidsamples.formvalidationapp

import androidx.annotation.StringRes

data class AuthenticationUIState(
    val email: String = "",
    val password: String = "",
    val errorState: ValidationResult = ValidationSuccess
) {

    fun hasEmailError(): Boolean {
        if ((this.errorState is ValidationError) && (errorState.error is InvalidEmail)
        ) {
            return true
        }
        return false
    }

    @StringRes
    fun getEmailErrorMessage(): Int {
        if ((this.errorState is ValidationError) && (errorState.error is InvalidEmail)
        ) {
            return R.string.validation_form_not_valid_email_error
        }
        return R.string.validation_form_clear_field
    }

    fun hasPasswordError(): Boolean {
        if ((this.errorState is ValidationError) && (errorState.error is PasswordMinLength || errorState.error is PasswordLettersAndDigits)
        ) {
            return true
        }
        return false
    }

    @StringRes
    fun getPasswordMessage(): Int {
        if (this.errorState is ValidationError) {
            if (errorState.error is PasswordMinLength)
                return R.string.validation_form_password_character_count_error
            else if (errorState.error is PasswordLettersAndDigits)
                return R.string.validation_form_password_character_content_error
        }
        return R.string.validation_form_clear_field
    }

}