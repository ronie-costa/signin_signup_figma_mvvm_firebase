package com.ronie.signinsignupfigmamvvm.data.data_source.database

import com.google.firebase.auth.FirebaseAuth
import com.ronie.signinsignupfigmamvvm.core.domain.model.UserModel
import javax.inject.Inject

class AuthDatabase @Inject constructor() {
    private val auth = FirebaseAuth.getInstance()

    fun signUpFirebaseAuth(
        user: UserModel,
        isSuccess: () -> Unit,
        isFailure: (String) -> Unit
    ) {
        val result = auth.createUserWithEmailAndPassword(user.email, user.password)
        result.addOnSuccessListener {
            isSuccess()
        }
        result.addOnFailureListener {
            val message = "E-mail ou senha invalidor, Tente Novamente"
            isFailure(message)
        }
    }
}