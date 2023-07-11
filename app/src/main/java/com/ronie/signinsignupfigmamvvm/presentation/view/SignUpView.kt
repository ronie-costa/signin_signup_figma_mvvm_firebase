package com.ronie.signinsignupfigmamvvm.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ronie.signinsignupfigmamvvm.R
import com.ronie.signinsignupfigmamvvm.presentation.ui.theme.Blue
import com.ronie.signinsignupfigmamvvm.presentation.ui.theme.BlueCyan
import com.ronie.signinsignupfigmamvvm.presentation.view_model.AuthViewModel


@Composable
fun SignUpView(
    navController: NavController,
    authViewModel: AuthViewModel
) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopSignupSection(navController)
        SignupSection()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SignupSection() {
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
        TextField(
            value = email,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                containerColor = Color(0x10000000),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color(0xFF000000),
                focusedLabelColor = Color(0x80000000)
            ),
            onValueChange = { email = it },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = password,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                containerColor = Color(0x10000000),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color(0xFF000000),
                focusedLabelColor = Color(0x80000000)
            ),
            onValueChange = { password = it },
            label = { Text("Senha") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = confirmPassword,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                containerColor = Color(0x10000000),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color(0xFF000000),
                focusedLabelColor = Color(0x80000000)
            ),
            onValueChange = { confirmPassword = it },
            label = { Text("Confirmar Senha") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
        )
        Spacer(modifier = Modifier.height(15.dp))
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Black
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            contentPadding = PaddingValues(),
            content = {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    Blue,
                                    BlueCyan
                                )
                            )
                        ),
                    content = {
                        Text(text = "Criar Conta", color = Color.White)
                    }
                )
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