package page.androidsamples.formvalidationapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import page.androidsamples.formvalidationapp.ui.theme.FormValidationAppTheme


@Composable
fun AuthenticationScreen(
    viewModel: AuthenticationViewModel = hiltViewModel(),
    navController: NavController,
) {
    val uiState = viewModel.state

    LaunchedEffect(key1 = LocalContext.current) {
    }

    Scaffold(backgroundColor = MaterialTheme.colors.primary) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(200.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = stringResource(id = R.string.app_name),
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                )
            }

            Card(
                Modifier
                    .weight(3f)
                    .padding(0.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        Column {
                            TextField(
                                value = uiState.email,
                                onValueChange = {
                                    viewModel.onEvent(AuthenticationFormEvent.EmailChanged(it))
                                },
                                label = {
                                    Text(text = stringResource(id = R.string.validation_form_email_field_placeholder))
                                },
                                maxLines = 1,
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Email,
                                    imeAction = ImeAction.Done
                                ),
                                isError = uiState.hasEmailError(),
                                modifier = Modifier.fillMaxWidth(),
                            )

                            if (uiState.hasEmailError()) {
                                Text(
                                    text = stringResource(id = uiState.getEmailErrorMessage()),
                                    color = MaterialTheme.colors.error,
                                    style = MaterialTheme.typography.caption,
                                    modifier = Modifier.padding(start = 16.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(32.dp))

                        Column {
                            TextField(
                                value = uiState.password,
                                onValueChange = {
                                    viewModel.onEvent(AuthenticationFormEvent.PasswordChanged(it))
                                },
                                label = {
                                    Text(text = stringResource(id = R.string.validation_form_password_field_placeholder))
                                },
                                maxLines = 1,
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Password,
                                    imeAction = ImeAction.Done
                                ),

                                isError = uiState.hasPasswordError(),
                                modifier = Modifier.fillMaxWidth(),
                            )
                            if (uiState.hasPasswordError()) {
                                Text(
                                    text = stringResource(id = uiState.getPasswordMessage()),
                                    color = MaterialTheme.colors.error,
                                    style = MaterialTheme.typography.caption,
                                    modifier = Modifier.padding(start = 16.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(32.dp))
                        Button(
                            onClick = {
                                viewModel.onEvent(AuthenticationFormEvent.SubmitForm)
                            },
                            enabled = true,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(text = stringResource(id = R.string.validation_form_submit_button))
                        }
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AuthenticationScreen_Preview() {
    FormValidationAppTheme {
        val navController = rememberNavController()
        AuthenticationScreen(navController = navController)
    }
}