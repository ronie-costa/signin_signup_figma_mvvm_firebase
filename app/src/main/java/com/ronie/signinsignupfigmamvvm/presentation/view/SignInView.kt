package com.ronie.signinsignupfigmamvvm.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ronie.signinsignupfigmamvvm.R
import com.ronie.signinsignupfigmamvvm.core.sealed.Routes
import com.ronie.signinsignupfigmamvvm.presentation.ui.theme.Blue
import com.ronie.signinsignupfigmamvvm.presentation.ui.theme.BlueCyan
import com.ronie.signinsignupfigmamvvm.presentation.view_model.AuthViewModel


@Composable
fun SignInView(
    navController: NavController,
    authViewModel: AuthViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TopSignInSection()
        SignInSection(navController)
        Text(
            text = "OU",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(20.dp))
        SocialSignInSection()
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1f)
                .padding(20.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Row(
                modifier = Modifier
                    .clickable {
                        navController.navigate(Routes.SignUpView.route)
                    }
            ) {
                Text(
                    text = "ainda não tem uma conta?",
                    color = Color(0x50000000),
                    modifier = Modifier.padding(5.dp)
                )
                Text(
                    text = "Cadastre-se",
                    color = Color(0x90000000),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 5.dp, bottom = 5.dp, end = 5.dp)
                )
            }
        }
    }
}


@Composable
private fun SocialSignInSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
    ) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .weight(1f)
                .height(55.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0x20000000),
                contentColor = Color.Black
            ),
            content = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_google),
                        contentDescription = null,
                        modifier = Modifier.size(15.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "Google", color = Color(0x60000000))
                }
            }
        )
        Spacer(modifier = Modifier.width(20.dp))
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .weight(1f)
                .height(55.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0x20000000),
                contentColor = Color.Black
            ),
            content = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_facebook),
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "Facebook", color = Color(0x60000000))
                }
            }
        )
    }
}


@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun SignInSection(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            text = "Login",
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 10.dp, bottom = 10.dp),
            fontFamily = FontFamily(
                listOf(
                    Font(resId = R.font.koulen_regular, weight = FontWeight.Normal)
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
                keyboardType = KeyboardType.Password,
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
                        Text(text = "Login", color = Color.White)
                    }
                )
            }
        )
    }
}


@Composable
private fun TopSignInSection() {
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
                .fillMaxWidth()
                .fillMaxHeight(0.25f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Welcome Login",
                fontSize = 30.sp,
                color = Color.White,
                fontFamily = FontFamily(
                    listOf(
                        Font(resId = R.font.londrina_solid_regular, weight = FontWeight.Light)
                    )
                )
            )
        }
    }
}
