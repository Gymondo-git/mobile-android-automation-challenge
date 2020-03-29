package com.example.android.gymondoautomationtest.poms

import androidx.test.espresso.matcher.ViewMatchers
import com.example.android.gymondoautomationtest.util.Robot
import com.example.android.gymondoautomationtest.R

class LoginScreen {

    fun loginField() = Robot(
        viewMatcher = ViewMatchers.withId(R.id.loginField),
        elementName = "Login Field"
    )

    fun passwordField() = Robot(
        viewMatcher = ViewMatchers.withId(R.id.passwordField),
        elementName = "Password Field"
    )

    fun loginButton() = Robot(
        viewMatcher = ViewMatchers.withText(R.string.login),
        elementName = "Login Button"
    )

    fun enterUserName(login: String): LoginScreen {
        loginField().tap().typeText(login).textShouldBe(login)
        return this
    }

    fun enterPassword(password: String): LoginScreen {
        passwordField().tap().typeText(password).textShouldBe(password).closeKeyboard()
        return this
    }

    fun tapLogin(): LoginScreen {
        loginButton().tap()
        return this
    }

    fun loginShouldBeSuccessful(): ActivitiesScreen {
        loginButton().isNotDisplayed()
        return ActivitiesScreen()
    }
}