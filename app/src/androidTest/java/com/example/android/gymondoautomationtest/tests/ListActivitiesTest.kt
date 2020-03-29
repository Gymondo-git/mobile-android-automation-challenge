package com.example.android.gymondoautomationtest.tests

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.android.gymondoautomationtest.util.ExercisesModel
import com.example.android.gymondoautomationtest.ListActivity
import com.example.android.gymondoautomationtest.poms.ActivitiesScreen
import com.example.android.gymondoautomationtest.util.fromJson
import com.google.gson.Gson
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.net.URL
import java.nio.charset.Charset

@RunWith(AndroidJUnit4::class)
class ListActivitiesTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(ListActivity::class.java)

    private lateinit var listOfResults: List<String>
    private lateinit var exercise: String
    private val activitiesScreen = ActivitiesScreen()

    @Before
    fun setupTest() {
        val exercises: ExercisesModel = Gson()
            .fromJson(URL("https://wger.de/api/v2/exercise/?limit=30&status=2&language=2")
                .readText(Charset.defaultCharset()))
        listOfResults = exercises.getListOfValidResults()
        exercise = listOfResults.random()
    }

    @Test
    fun canSearchForExercise() {
        activitiesScreen
            .inputExercise(exercise)
            .tapSearch()
            .searchResultShouldBe(exercise)
    }

    @Test
    fun canSearchAllExercisesAvailable() {
        listOfResults.forEach {
            activitiesScreen.searchBar()
                .tap()
                .typeText(it)
            activitiesScreen.searchButton().tap()
            activitiesScreen.exerciseCell(it).isDisplayed()
            activitiesScreen.clearSearch()
        }
    }

}