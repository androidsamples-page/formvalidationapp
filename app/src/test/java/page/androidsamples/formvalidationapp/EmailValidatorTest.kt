package page.androidsamples.formvalidationapp

import com.google.common.truth.Truth
import org.junit.Test
import com.google.common.truth.Truth.assertThat


class EmailValidatorTest {

    @Test
    fun `given valid email, then should return ValidationSuccess`() {

        // Given
        val validator = EmailValidator

        // When
        val actualResult = validator.validate(AuthFormDataFactory.createValidForm())

        // Then
        assertThat(actualResult).isInstanceOf(ValidationSuccess::class.java)
    }

    @Test
    fun `given not valid email, then should return InvalidEmail`() {

        // Given
        val validator = EmailValidator

        // When
        val actualResult = validator.validate(AuthFormDataFactory.createInvalidEmailForm())

        // Then
        assertThat(((actualResult) as ValidationError).error)
            .isInstanceOf(InvalidEmail::class.java)
    }
}