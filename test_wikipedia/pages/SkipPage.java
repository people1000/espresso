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

public class SkipPage {
    public void skipMessage(){
        onView(Matchers.allOf(ViewMatchers.withId(R.id.fragment_onboarding_skip_button), isDisplayed())).perform(click());
    }
    public void skipThanks(){
        onView(allOf(withText("NO THANKS"),isDisplayed())).perform(click());
    }
    public void skipLogout(){
        onView(allOf(withText("LOG OUT"), isDisplayed())).perform(click());
    }
}
