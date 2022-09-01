package com.example.encryptiondecryptiondemo;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class OneWayEncryptionInstrumentedTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void oneWayEncryptionEspressoTest() {
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.OneWayBtn), withText("One-way Encryption"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.FirstPassword),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("testing123"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.SecondPassword),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("testing234"), closeSoftKeyboard());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.CheckPasswordMatchBtn), withText("Encrypt and Check-Match"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.nomatchTextView), withText("MISMATCH!"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        textView.check(matches(withText("MISMATCH!")));

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.SecondPassword), withText("testing234"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText3.perform(click());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.SecondPassword), withText("testing234"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText4.perform(replaceText("testing123"));

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.SecondPassword), withText("testing123"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText5.perform(closeSoftKeyboard());

        ViewInteraction materialButton3 = onView(
                allOf(withId(R.id.CheckPasswordMatchBtn), withText("Encrypt and Check-Match"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        materialButton3.perform(click());

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.matchTextView), withText("MATCH!"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        textView2.check(matches(withText("MATCH!")));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
