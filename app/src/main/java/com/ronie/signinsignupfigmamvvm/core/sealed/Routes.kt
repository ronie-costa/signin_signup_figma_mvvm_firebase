package com.ronie.signinsignupfigmamvvm.core.sealed

sealed class Routes(val route: String) {
    object SignInView: Routes("sign_in_view")
    object SignUpView: Routes("sign_up_view")
    object HomeView: Routes("home_view")
}