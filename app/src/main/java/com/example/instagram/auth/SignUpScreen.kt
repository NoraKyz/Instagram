package com.example.instagram.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.instagram.DestinationScreen
import com.example.instagram.IgViewModel
import com.example.instagram.components.LogoInstagram
import com.example.instagram.components.ProgressSpinner
import com.example.instagram.components.navigateTo


@Composable
fun SignUpScreen(navController: NavController, viewModel: IgViewModel) {

    val focus = LocalFocusManager.current

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize(  )
                 .wrapContentHeight()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
             horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val usernameState = rememberSaveable { mutableStateOf("") }
            val emailState = rememberSaveable { mutableStateOf("") }
            val passwordState = rememberSaveable { mutableStateOf("") }

            LogoInstagram()


            Text(
                text = "SignUp",
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(8.dp)
            )

            OutlinedTextField(
                value = usernameState.value,
                onValueChange = { usernameState.value = it },
                label = { Text(text = "Username") },
                modifier = Modifier.padding(8.dp)
            )

            OutlinedTextField(
                value = emailState.value,
                onValueChange = { emailState.value = it },
                label = { Text(text = "Email") },
                modifier = Modifier.padding(8.dp)
            )

            OutlinedTextField(
                value = passwordState.value,
                onValueChange = { passwordState.value = it },
                label = { Text(text = "Password") },
                modifier = Modifier.padding(8.dp),
                visualTransformation = PasswordVisualTransformation()
            )

            Button(onClick = {
                focus.clearFocus(true)

                viewModel.onSignup(
                    usernameState.value.trim(),
                    emailState.value.trim(),
                    passwordState.value.trim()
                )
            }, modifier = Modifier.padding(8.dp)) {
                Text(text = "SIGN UP")
            }

            Text(
                text = "Already a user? Do to login ->",
                color = Color.Blue,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable {
                        navigateTo(navController, DestinationScreen.Login)
                    })


        }
        val isLoading = viewModel.inProgress.value
        if (isLoading) {
            ProgressSpinner()
        }

    }
}
