package com.ronie.signinsignupfigmamvvm.presentation.view_model

import androidx.lifecycle.ViewModel
import com.ronie.signinsignupfigmamvvm.core.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val repository: AuthRepository) : ViewModel() {
}