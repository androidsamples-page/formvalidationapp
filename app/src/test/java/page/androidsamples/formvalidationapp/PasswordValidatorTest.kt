package page.androidsamples.formvalidationapp

import com.google.common.truth.Truth
import org.junit.Test


internal class PasswordValidatorTest {

    @Test
    fun `given valid password, then should return ValidationSuccess`() {

        // Given
        val validator = PasswordValidator

        // When
        val actualResult = validator.validate(AuthFormDataFactory.createValidForm())

        // Then
        Truth.assertThat(actualResult).isInstanceOf(ValidationSuccess::class.java)
    }

    @Test
    fun `given LT 6 character password, then should return PasswordMinLength`() {

        // Given
        val validator = PasswordValidator

        // When
        val actualResult = validator.validate(AuthFormDataFactory.createMinCharPasswordForm())

        // Then
        Truth.assertThat(((actualResult) as ValidationError).error)
            .isInstanceOf(PasswordMinLength::class.java)
    }

    @Test
    fun `given only digit character password, then should return PasswordLettersAndDigits`() {

        // Given
        val validator = PasswordValidator

        // When
        val actualResult = validator.validate(AuthFormDataFactory.createOnlyDigitPasswordForm())

        // Then
        Truth.assertThat(((actualResult) as ValidationError).error)
            .isInstanceOf(PasswordLettersAndDigits::class.java)
    }

    @Test
    fun `given only letter character password, then should return PasswordLettersAndDigits`() {

        // Given
        val validator = PasswordValidator

        // When
        val actualResult = validator.validate(AuthFormDataFactory.createOnlyLetterPasswordForm())

        // Then
        Truth.assertThat(((actualResult) as ValidationError).error)
            .isInstanceOf(PasswordLettersAndDigits::class.java)
    }
}