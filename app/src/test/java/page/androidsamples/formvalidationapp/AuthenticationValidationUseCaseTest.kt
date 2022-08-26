package page.androidsamples.formvalidationapp

import com.google.common.truth.Truth
import org.junit.Test

class AuthenticationValidationUseCaseTest {


    @Test
    fun `given valid form, then should return ValidationSuccess`() {

        // Given
        val validationUseCase = AuthenticationValidationUseCase()

        // When
        val actualResult = validationUseCase.validate(AuthFormDataFactory.createValidForm())

        // Then
        Truth.assertThat(actualResult).isInstanceOf(ValidationSuccess::class.java)
    }

    @Test
    fun `given invalid email form, then should return InvalidEmail`() {

        // Given
        val validationUseCase = AuthenticationValidationUseCase()

        // When
        val actualResult = validationUseCase.validate(AuthFormDataFactory.createInvalidEmailForm())

        // Then
        Truth.assertThat(((actualResult) as ValidationError).error)
            .isInstanceOf(InvalidEmail::class.java)
    }

    @Test
    fun `given min char password form, then should return PasswordMinLength`() {

        // Given
        val validationUseCase = AuthenticationValidationUseCase()

        // When
        val actualResult =
            validationUseCase.validate(AuthFormDataFactory.createMinCharPasswordForm())

        // Then
        Truth.assertThat(((actualResult) as ValidationError).error)
            .isInstanceOf(PasswordMinLength::class.java)
    }

    @Test
    fun `given only letter password form, then should return PasswordLettersAndDigits`() {

        // Given
        val validationUseCase = AuthenticationValidationUseCase()

        // When
        val actualResult =
            validationUseCase.validate(AuthFormDataFactory.createOnlyLetterPasswordForm())

        // Then
        Truth.assertThat(((actualResult) as ValidationError).error)
            .isInstanceOf(PasswordLettersAndDigits::class.java)
    }

    @Test
    fun `given only digit password form, then should return PasswordLettersAndDigits`() {

        // Given
        val validationUseCase = AuthenticationValidationUseCase()

        // When
        val actualResult =
            validationUseCase.validate(AuthFormDataFactory.createOnlyLetterPasswordForm())

        // Then
        Truth.assertThat(((actualResult) as ValidationError).error)
            .isInstanceOf(PasswordLettersAndDigits::class.java)
    }
}