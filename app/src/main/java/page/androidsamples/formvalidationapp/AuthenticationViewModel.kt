package page.androidsamples.formvalidationapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(
    private val validationUseCase: AuthenticationValidationUseCase
) : ViewModel() {

    var state by mutableStateOf(AuthenticationUIState())

    fun onEvent(event: AuthenticationFormEvent) {
        when (event) {
            is AuthenticationFormEvent.EmailChanged -> {
                state = state.copy(email = event.email)
            }
            is AuthenticationFormEvent.PasswordChanged -> {
                state = state.copy(password = event.password)
            }
            is AuthenticationFormEvent.SubmitForm -> {
                submitForm()
            }
        }
    }

    private fun submitForm() {
        val formData = AuthFormData(email = state.email, password = state.password)
        when (val result = validationUseCase.validate(formData)) {
            is ValidationError -> {
                state = state.copy(errorState = result)
            }
            ValidationSuccess -> {
                navigate()
            }
        }
    }

    private fun navigate() {
        viewModelScope.launch {
        }
    }

    sealed class ValidationResultEvent {
        object Navigate : ValidationResultEvent()
    }
}