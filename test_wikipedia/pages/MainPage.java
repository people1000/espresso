package org.wikipedia.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.matcher.ViewMatchers;

import org.hamcrest.Matchers;
import org.wikipedia.R;

public class MainPage {
    public void clickNavMore(){
        onView(Matchers.allOf(ViewMatchers.withId(R.id.nav_more_container), isDisplayed())).perform(click());
    }
}
