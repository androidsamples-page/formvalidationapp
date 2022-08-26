package page.androidsamples.formvalidationapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigator() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.AuthScreen.route
    ) {
        composable(Screens.AuthScreen.route) {
            AuthenticationScreen(
                navController = navController
            )
        }
    }
}

sealed class Screens(val route: String) {
    object AuthScreen : Screens("auth_screen")
}