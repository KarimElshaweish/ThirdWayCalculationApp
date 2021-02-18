package com.karim.thirdwaycalculationapp.View


import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.karim.thirdwaycalculationapp.R
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {


    private lateinit var stringToBetyped: String
    @get:Rule
    var activityRule:ActivityScenarioRule<MainActivity>
        =ActivityScenarioRule(MainActivity::class.java)
    @Before
    fun setUp() {
        stringToBetyped = "2"

    }

    @After
    fun tearDown() {
    }

    @Test
    fun testTheUserInputScenarioSummation(){

        //init the result
        val actualResult:Double= 2.0
         // input number text from the edit text in the ui
        onView(withId(R.id.sNumber)).perform(typeText(stringToBetyped))

        //preform the plus action
        onView(withId(R.id.plusTextView)).perform(click())

        // preform the equal button
        onView(withId(R.id.resultEqualTextView)).perform(click())

         // checking the text in the text view
        onView(withId(R.id.result)).check(matches(withText(actualResult.toString())))
    }

    @Test
    fun testTheUserInputScenarioSubtaction(){
        //init the result
        val actualResult:Double= -2.0
        // input number text from the edit text in the ui
        onView(withId(R.id.sNumber)).perform(typeText(stringToBetyped))

        //preform the subtraction action
        onView(withId(R.id.subtractionTextView)).perform(click())

        // preform the equal button
        onView(withId(R.id.resultEqualTextView)).perform(click())

        // checking the text in the text view
        onView(withId(R.id.result)).check(matches(withText(actualResult.toString())))
    }

    @Test
    fun testTheUserInputScenarioMultiplication(){
        //init the result
        val actualResult:Double= 0.0
        // input number text from the edit text in the ui
        onView(withId(R.id.sNumber)).perform(typeText(stringToBetyped))

        //preform the multiplication action
        onView(withId(R.id.multplicationTextView)).perform(click())

        // preform the equal button
        onView(withId(R.id.resultEqualTextView)).perform(click())

        // checking the text in the text view
        onView(withId(R.id.result)).check(matches(withText(actualResult.toString())))
    }

    @Test
    fun testTheUserInputScenarioDivison(){
        //init the result
        val actualResult:Double= 0.0
        // input number text from the edit text in the ui
        onView(withId(R.id.sNumber)).perform(typeText(stringToBetyped))

        //preform the division action
        onView(withId(R.id.divisonTextView)).perform(click())

        // preform the equal button
        onView(withId(R.id.resultEqualTextView)).perform(click())

        // checking the text in the text view
        onView(withId(R.id.result)).check(matches(withText(actualResult.toString())))
    }
}