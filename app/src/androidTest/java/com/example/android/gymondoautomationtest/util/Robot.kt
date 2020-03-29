package com.example.android.gymondoautomationtest.util

import android.view.View
import androidx.test.espresso.*
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher
import org.junit.Assert
import java.util.concurrent.TimeUnit

class Robot(
    viewMatcher: Matcher<View>,
    elementName: String
) {

    private val _viewMatcher = viewMatcher
    private val _elementName = elementName

    fun tap(): Robot {
        println("Tapping on $_elementName")
        Espresso.onView(_viewMatcher).perform(ViewActions.click())
        return this
    }

    fun typeText(text: String): Robot {
        println("Writing text $text on element $_elementName")

        Espresso.onView(_viewMatcher).perform(ViewActions.typeText(text))
        return this
    }

    fun closeKeyboard(): Robot {
        println("Closing Keyboard")
        Espresso.closeSoftKeyboard()
        return this
    }

    fun textShouldBe(text: String): Robot {
        Espresso.onView(_viewMatcher)
            .check(matches(ViewMatchers.withText(text)))
        return this
    }

    fun isEnabled(): Robot {
        println("Verifying if element $_elementName is Enabled")
        IdlingPolicies.setIdlingResourceTimeout(5, TimeUnit.SECONDS)
        Espresso.onView(_viewMatcher).check(matches(ViewMatchers.isEnabled()))
        return this
    }

    fun isNotDisplayed(): Robot {
        println("Verifying if element $_elementName is NOT Displayed")
        IdlingPolicies.setIdlingResourceTimeout(5, TimeUnit.SECONDS)
        Assert.assertFalse(Espresso.onView(_viewMatcher).isDisplayed())
        return this
    }

    fun isDisplayed(): Robot {
        println("Verifying if element $_elementName is Displayed")
        IdlingPolicies.setIdlingResourceTimeout(5, TimeUnit.SECONDS)
        Espresso.onView(_viewMatcher).check(matches(ViewMatchers.isDisplayed()))
        return this
    }
}

fun ViewInteraction.isDisplayed(): Boolean {
    return try {
        check(matches(ViewMatchers.isDisplayed()))
        true
    } catch (e: NoMatchingViewException) {
        false
    }
}