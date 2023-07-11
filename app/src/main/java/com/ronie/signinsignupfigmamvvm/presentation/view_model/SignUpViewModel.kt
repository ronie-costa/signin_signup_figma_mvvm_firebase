package com.ronie.signinsignupfigmamvvm.presentation.view_model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.ronie.signinsignupfigmamvvm.core.domain.model.UserModel
import com.ronie.signinsignupfigmamvvm.core.domain.repository.AuthRepository
import com.ronie.signinsignupfigmamvvm.core.sealed.AuthState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SignUpViewModel @Inject constructor(private val repository: AuthRepository) : ViewModel() {

    val signUpState: MutableState<AuthState> = mutableStateOf(AuthState.Initial)

    fun startSignUp(user: UserModel) {
        when {
            user.email.isEmpty() -> {
            }
            user.password.isEmpty() -> {
            }
            user.password.length <= 5 -> {
            }
            user.password != user.confirmPassword -> {
            }
            else -> {
                val isSuccess: () -> Unit = {
                    signUpState.value = AuthState.Success
                }
                val isFailure: (String) -> Unit = {
                    signUpState.value = AuthState.Failure
                }
                repository.startSignUpRepo(user, isSuccess, isFailure)
            }
        }
    }
}