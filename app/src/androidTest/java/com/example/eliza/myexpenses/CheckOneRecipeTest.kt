package com.example.eliza.myexpenses


import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isClickable
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import kotlinx.android.synthetic.main.activity_adding.view.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith



@RunWith(AndroidJUnit4::class)
@LargeTest
class CheckOneRecipeTest {



    @get:Rule
    //val activityRule : ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun clickOnButton(){
        onView(withId(R.id.btn_add)).perform(click())
        onView(withId(R.id.etvName)).perform(typeText("Jajecznica"), closeSoftKeyboard())
        onView(withId(R.id.btn_go_ingredients)).perform(click())
        onView(withId(R.id.text_add_ingr)).perform(typeText("2 jajka"),closeSoftKeyboard())
        onView(withId(R.id.btn_add_ingr)).perform(click())
        onView(withId(R.id.text_add_ingr)).perform(typeText("10 g masla"), closeSoftKeyboard())
        onView(withId(R.id.btn_add_ingr)).perform(click())
        onView(withId(R.id.btn_go_desc)).check(matches(isClickable()))
        onView(withId(R.id.btn_go_desc)).perform(click())
        onView(withId(R.id.text_add_desc)).perform(typeText("Roztop maslo na patelni, wrzuc rozbite jajka, dopraw i smaz."), closeSoftKeyboard())
        onView(withId(R.id.btn_add_desc)).perform(click())
        onView(withId(R.id.btn_insert)).perform(click())
    }

}