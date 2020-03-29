package com.example.android.gymondoautomationtest.tests

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.android.gymondoautomationtest.poms.LoginScreen
import com.example.android.gymondoautomationtest.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)
    val loginScreen = LoginScreen()
    private val login = "automation@gymondo.de"
    private val password = "automation"

    @Test
    fun canLoginWithValidCredentials() {
        loginScreen
            .enterUserName(login)
            .enterPassword(password)
            .tapLogin()
            .loginShouldBeSuccessful()
            .searchBar().isEnabled()
    }

    @Test
    fun cantLoginWithInvalidCredentials() {
        loginScreen.tapLogin()
            .loginButton().isEnabled()
    }
}
