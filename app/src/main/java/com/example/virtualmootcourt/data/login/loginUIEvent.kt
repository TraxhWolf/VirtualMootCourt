package com.example.virtualmootcourt.data.login

sealed class LoginUIEvent {
    data class RegisterNumberChanged(val registerNumber: String) : LoginUIEvent()
    data class PasswordChanged(val password: String) : LoginUIEvent()
    object LoginButtonClicked: LoginUIEvent()
}