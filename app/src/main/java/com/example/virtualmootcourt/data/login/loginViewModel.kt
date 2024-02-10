package com.example.virtualmootcourt.data.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.virtualmootcourt.navigation.Screen
import com.example.virtualmootcourt.navigation.VMCNavigation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener

class LoginViewModel : ViewModel() {
    private var loginUIState = mutableStateOf(LoginUIState())
    private var loginInProgress = mutableStateOf(false)
    fun onEvent(event: LoginUIEvent) {
        when(event) {
            is LoginUIEvent.RegisterNumberChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    registerNumber = event.registerNumber
                )
            }
            is LoginUIEvent.PasswordChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    password = event.password
                )
            }
            is LoginUIEvent.LoginButtonClicked -> {
                login()
            }
        }
    }

    fun login() {
        val email = loginUIState.value.registerNumber
        val password = loginUIState.value.password
        loginInProgress.value = true
        FirebaseAuth
            .getInstance()
            .signInWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    VMCNavigation.navigateTo(Screen.Rules)
                } else {
                    VMCNavigation.navigateTo(Screen.LoginError)
                }
            }
            .addOnFailureListener {}
    }

    fun logout() {
        val firebaseAuth = FirebaseAuth.getInstance()
        firebaseAuth.signOut()
        val authStateListener = AuthStateListener {
            if(it.currentUser == null) {
                VMCNavigation.navigateTo(Screen.Home)
            }
        }
        firebaseAuth.addAuthStateListener(authStateListener)
    }
}