package page.androidsamples.formvalidationapp

object AuthFormDataFactory {

    fun createValidForm(): AuthFormData {
        return AuthFormData(email = "email@email.com", "1234qwe")
    }

    fun createInvalidEmailForm(): AuthFormData {
        return AuthFormData(email = "email@email", "1234qwe")
    }

    fun createMinCharPasswordForm(): AuthFormData {
        return AuthFormData(email = "email@email.com", "12qwe")
    }

    fun createOnlyDigitPasswordForm(): AuthFormData {
        return AuthFormData(email = "email@email.com", "1234567")
    }

    fun createOnlyLetterPasswordForm(): AuthFormData {
        return AuthFormData(email = "email@email.com", "qweasdr")
    }
}