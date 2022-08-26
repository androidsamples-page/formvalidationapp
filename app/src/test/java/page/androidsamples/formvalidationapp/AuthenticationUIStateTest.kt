package page.androidsamples.formvalidationapp

import com.google.common.truth.Truth
import org.junit.Test


class AuthenticationUIStateTest {

    @Test
    fun `given InvalidEmail error, then hasEmailError should return true`() {

        // Given
        val givenUIState = createUIState(ValidationError(InvalidEmail))

        // When
        val actualResult = givenUIState.hasEmailError()

        // Then
        Truth.assertThat(actualResult).isTrue()

    }

    @Test
    fun `given ValidationSuccess result, then hasEmailError should return false`() {

        // Given
        val givenUIState = createUIState(ValidationSuccess)

        // When
        val actualResult = givenUIState.hasEmailError()

        // Then
        Truth.assertThat(actualResult).isFalse()

    }

    @Test
    fun `given ValidationSuccess result, then hasPasswordError should return false`() {

        // Given
        val givenUIState = createUIState(ValidationSuccess)

        // When
        val actualResult = givenUIState.hasPasswordError()

        // Then
        Truth.assertThat(actualResult).isFalse()

    }

    @Test
    fun `given PasswordMinLength error, then hasPasswordError should return true`() {

        // Given
        val givenUIState = createUIState(ValidationError(PasswordMinLength))

        // When
        val actualResult = givenUIState.hasPasswordError()

        // Then
        Truth.assertThat(actualResult).isTrue()

    }

    @Test
    fun `given PasswordLettersAndDigits error, then hasPasswordError should return true`() {

        // Given
        val givenUIState = createUIState(ValidationError(PasswordLettersAndDigits))

        // When
        val actualResult = givenUIState.hasPasswordError()

        // Then
        Truth.assertThat(actualResult).isTrue()

    }

    private fun createUIState(errorState: ValidationResult): AuthenticationUIState {
        return AuthenticationUIState(errorState = errorState)
    }

}