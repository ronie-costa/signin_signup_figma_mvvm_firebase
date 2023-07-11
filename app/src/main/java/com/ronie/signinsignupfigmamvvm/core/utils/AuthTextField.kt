package com.ronie.signinsignupfigmamvvm.core.utils

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthTextFiled(
    value: String,
    label: @Composable () -> Unit,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = value,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            containerColor = Color(0x10000000),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = Color(0xFF000000),
            focusedLabelColor = Color(0x80000000)
        ),
        onValueChange = onValueChange,
        label = label,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
        ),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp),
    )
}