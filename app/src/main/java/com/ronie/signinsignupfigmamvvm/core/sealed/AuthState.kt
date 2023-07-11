package com.ronie.signinsignupfigmamvvm.core.sealed

sealed class AuthState {
    object Initial: AuthState()
    object Success: AuthState()
    object Failure: AuthState()
}
