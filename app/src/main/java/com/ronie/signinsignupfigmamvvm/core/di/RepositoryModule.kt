package com.ronie.signinsignupfigmamvvm.core.di

import com.ronie.signinsignupfigmamvvm.core.domain.repository.AuthRepository
import com.ronie.signinsignupfigmamvvm.data.repository.AuthRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {
    @Binds
    fun bindAuthRepository(
        authRepository: AuthRepositoryImpl
    ) : AuthRepository
}