package page.androidsamples.formvalidationapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import page.androidsamples.formvalidationapp.ui.theme.FormValidationAppTheme

@HiltAndroidTest
class AuthenticationScreenTests {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun test_PageTitleIsDisplayed() {
        // Start the app
        composeTestRule.setContent {
            val navController = rememberNavController()
            FormValidationAppTheme {
                AuthenticationScreen(navController = navController)
            }
        }

        composeTestRule.onNodeWithText("Form Validation App").assertIsDisplayed()
    }

    @Test
    fun test_InvalidEmail() {
        // Start the app
        composeTestRule.setContent {
            val navController = rememberNavController()
            FormValidationAppTheme {
                AuthenticationScreen(navController = navController)
            }
        }

    }

    @Test
    fun test_InvalidPassword() {
        // Start the app
        composeTestRule.setContent {
            val navController = rememberNavController()
            FormValidationAppTheme {
                AuthenticationScreen(navController = navController)
            }
        }

    }

    @Test
    fun test_SuccessfulAuthResult() {
        // Start the app
        composeTestRule.setContent {
            val navController = rememberNavController()
            FormValidationAppTheme {
                AuthenticationScreen(navController = navController)
            }
        }

    }
}