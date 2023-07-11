package com.ronie.signinsignupfigmamvvm.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ronie.signinsignupfigmamvvm.R
import com.ronie.signinsignupfigmamvvm.core.domain.model.UserModel
import com.ronie.signinsignupfigmamvvm.core.sealed.AuthState
import com.ronie.signinsignupfigmamvvm.core.sealed.Routes
import com.ronie.signinsignupfigmamvvm.core.utils.AuthButton
import com.ronie.signinsignupfigmamvvm.core.utils.AuthTextFiled
import com.ronie.signinsignupfigmamvvm.presentation.view_model.SignUpViewModel


@Composable
fun SignUpView(
    navController: NavController,
    signUpViewModel: SignUpViewModel
) {
    if (signUpViewModel.signUpState.value == AuthState.Success) {
        LaunchedEffect(key1 = null) {
            navController.navigate(Routes.HomeView.route)
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TopSignupSection(navController)
        SignupSection(signUpViewModel)
    }
}


@Composable
private fun SignupSection(signUpViewModel: SignUpViewModel) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            text = "Criar Conta",
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 10.dp, bottom = 10.dp),
            fontFamily = FontFamily(
                listOf(
                    Font(resId = R.font.koulen_regular, weight = FontWeight.Bold)
                )
            )
        )
        AuthTextFiled(
            value = email,
            label = { Text("Email") },
            onValueChange = { email = it }
        )
        Spacer(modifier = Modifier.height(10.dp))
        AuthTextFiled(
            value = password,
            label = { Text("Senha") },
            onValueChange = { password = it }
        )
        Spacer(modifier = Modifier.height(10.dp))
        AuthTextFiled(
            value = confirmPassword,
            label = { Text("Confirmar Senha") },
            onValueChange = { confirmPassword = it }
        )
        Spacer(modifier = Modifier.height(15.dp))
        AuthButton(
            onClick = {
                signUpViewModel.startSignUp(
                    UserModel(
                        email = email,
                        password = password,
                        confirmPassword = confirmPassword
                    )
                )
            },
            content = {
                Text(text = "Criar Conta", color = Color.White)
            }
        )
    }
}


@Composable
private fun TopSignupSection(navController: NavController) {
    Box {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f),
            painter = painterResource(id = R.drawable.background_top),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Box(
            modifier = Modifier
                .size(50.dp)
                .clickable { navController.popBackStack() },
            contentAlignment = Alignment.Center,
            content = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_arrow_back),
                    contentDescription = null,
                    tint = Color.White
                )
            }
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.25f),
            contentAlignment = Alignment.Center,
            content = {
                Text(
                    text = "Welcome Criar Conta",
                    fontSize = 30.sp,
                    color = Color.White,
                    fontFamily = FontFamily(
                        listOf(
                            Font(
                                resId = R.font.londrina_solid_regular,
                                weight = FontWeight.Light
                            )
                        )
                    )
                )
            }
        )
    }
}