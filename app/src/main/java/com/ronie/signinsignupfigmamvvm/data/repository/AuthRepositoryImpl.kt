package com.ronie.signinsignupfigmamvvm.data.repository

import com.ronie.signinsignupfigmamvvm.core.domain.model.UserModel
import com.ronie.signinsignupfigmamvvm.core.domain.repository.AuthRepository
import com.ronie.signinsignupfigmamvvm.data.data_source.database.AuthDatabase
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class AuthRepositoryImpl @Inject constructor(
    private val authDatabase: AuthDatabase,
) : AuthRepository {

    override fun startLoginRepo(
        user: UserModel,
        isSuccess: () -> Unit,
        isFailure: (String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun startSignUpRepo(
        user: UserModel,
        isSuccess: () -> Unit,
        isFailure: (String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun logOut(isLogOut: (Boolean) -> Unit) {
        TODO("Not yet implemented")
    }

}