package com.example.android.gymondoautomationtest.poms

import androidx.test.espresso.matcher.ViewMatchers
import com.example.android.gymondoautomationtest.util.Robot

class ActivitiesScreen {

    fun searchBar() = Robot(
        viewMatcher = ViewMatchers.withResourceName("editTxtSearch"),
        elementName = "Search Bar"
    )

    fun searchButton() = Robot(
        viewMatcher = ViewMatchers.withResourceName("btnSearch"),
        elementName = "Search Button"
    )

    fun exerciseCell(exerciseName: String) = Robot(
        viewMatcher = ViewMatchers.withContentDescription(exerciseName),
        elementName = "Exercise \"$exerciseName\" Cell"
    )

    fun clearButton() = Robot(
        viewMatcher = ViewMatchers.withResourceName("btnClear"),
        elementName = "Clear Button"
    )

    fun inputExercise(exercise: String): ActivitiesScreen {
        searchBar().typeText(exercise).textShouldBe(exercise)
        return this
    }

    fun tapSearch(): ActivitiesScreen {
        searchButton().tap()
        return this
    }

    fun searchResultShouldBe(exercise: String): ActivitiesScreen {
        exerciseCell(exercise).isEnabled()
        return this
    }

    fun clearSearch(): ActivitiesScreen {
        clearButton().tap()
        return this
    }
}