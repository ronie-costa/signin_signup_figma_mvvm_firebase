package com.ronie.signinsignupfigmamvvm.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ronie.signinsignupfigmamvvm.core.sealed.Routes
import com.ronie.signinsignupfigmamvvm.presentation.ui.theme.SigninSignupFigmaMVVMTheme
import com.ronie.signinsignupfigmamvvm.presentation.view.HomeView
import com.ronie.signinsignupfigmamvvm.presentation.view.SignInView
import com.ronie.signinsignupfigmamvvm.presentation.view.SignUpView
import com.ronie.signinsignupfigmamvvm.presentation.view_model.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    private lateinit var authViewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SigninSignupFigmaMVVMTheme {
                navController = rememberNavController()
                authViewModel = hiltViewModel()
                
                NavHost(
                    navController = navController,
                    startDestination = Routes.SignInView.route
                ) {
                    composable(route = Routes.SignInView.route) {
                        SignInView(navController, authViewModel)
                    }
                    composable(route = Routes.SignUpView.route) {
                        SignUpView(navController, authViewModel)
                    }
                    composable(route = Routes.HomeView.route) {
                        HomeView(navController, authViewModel)
                    }
                }
            }
        }
    }
}