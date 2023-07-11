package com.ronie.signinsignupfigmamvvm.core.domain.repository

import com.ronie.signinsignupfigmamvvm.core.domain.model.UserModel

interface AuthRepository {
    fun startLoginRepo(
        user: UserModel,
        isSuccess: () -> Unit,
        isFailure: (String) -> Unit
    )
    fun startSignUpRepo(
        user: UserModel,
        isSuccess: () -> Unit,
        isFailure: (String) -> Unit
    )
    fun logOut(isLogOut: (Boolean) -> Unit)
}