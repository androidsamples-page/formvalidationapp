package page.androidsamples.formvalidationapp


sealed class AuthenticationFormEvent {
    data class EmailChanged(val email: String) : AuthenticationFormEvent()
    data class PasswordChanged(val password: String) : AuthenticationFormEvent()
    object SubmitForm : AuthenticationFormEvent()
}