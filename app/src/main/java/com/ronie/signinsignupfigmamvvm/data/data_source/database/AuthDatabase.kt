package com.ronie.signinsignupfigmamvvm.data.data_source.database

import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class AuthDatabase @Inject constructor() {
    private val auth = FirebaseAuth.getInstance()


}