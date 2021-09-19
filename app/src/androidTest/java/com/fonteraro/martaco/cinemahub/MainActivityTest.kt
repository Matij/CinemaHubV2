package com.fonteraro.martaco.cinemahub

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.fonteraro.martaco.cinemahub.ui.main.MainActivity
import com.fonteraro.martaco.cinemahub.utils.RecyclerViewItemCountAssertion
import com.fonteraro.martaco.cinemahub.utils.RecyclerViewMatcher
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity>
            = ActivityScenarioRule(MainActivity::class.java)

    private lateinit var activityScenario: ActivityScenario<MainActivity>

    @Test
    fun givenDataAvailableDisplayPopulatedRecyclerView() {
        startActivity()

        onView(withId(R.id.emptyView))
            .check(matches(withText("Whoops, we didn't find any movies!")))
        onView(withId(R.id.recycler_view)).check(RecyclerViewItemCountAssertion(0))

        Thread.sleep(1000)

        onView(withId(R.id.emptyView)).check(matches(not(isDisplayed())))
        onView(withId(R.id.recycler_view)).check(RecyclerViewItemCountAssertion(25))
    }

    @Test
    fun givenDataAvailableWhenMovieClickedDetailsShown() {
        startActivity()

        onView(withId(R.id.emptyView))
            .check(matches(withText("Whoops, we didn't find any movies!")))
        onView(withId(R.id.recycler_view)).check(RecyclerViewItemCountAssertion(0))

        Thread.sleep(1000)

        onView(withId(R.id.emptyView)).check(matches(not(isDisplayed())))
        onView(withId(R.id.recycler_view)).check(RecyclerViewItemCountAssertion(25))
        onView(RecyclerViewMatcher(R.id.recycler_view).atPosition(0)).perform(click())
        onView(withId(R.id.title_textview)).check(matches(isDisplayed()))
    }

    private fun startActivity() {
        val context = ApplicationProvider.getApplicationContext<CinemaHubApplication>()
        val intent = Intent(context, MainActivity::class.java)
        activityScenario = ActivityScenario.launch(intent)
    }
}
