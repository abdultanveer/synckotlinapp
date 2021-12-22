package com.abdul.synckotlinapp

import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith




@LargeTest
@RunWith(AndroidJUnit4::class)
class MyActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun loginTest() {
        var mStringToBetyped = "synchronous"
        //get the handle on the edittext
        onView(withId(R.id.etEmail))
        //type abdul in that edittext
        .perform(typeText(mStringToBetyped), closeSoftKeyboard());
        //click the submit button
        onView(withId(R.id.btnSubmit)).perform(click());
        //check if the tvMain has abdul in it
        onView(withId(R.id.tvMain))
            .check(matches(withText(mStringToBetyped)));
    }

    }