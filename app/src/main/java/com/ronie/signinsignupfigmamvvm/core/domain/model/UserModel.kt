package com.ronie.signinsignupfigmamvvm.core.domain.model

data class UserModel(
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = ""
)
