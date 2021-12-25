package org.wikipedia.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;

import org.hamcrest.Matchers;
import org.wikipedia.R;

public class SettingsPage {
    public void clickSettings(){
        onView(Matchers.allOf(ViewMatchers.withId(R.id.main_drawer_settings_container), isDisplayed())).perform(click());
    }
    public void logIn(){
        onView(Matchers.allOf(ViewMatchers.withId(R.id.main_drawer_login_button), isDisplayed())).perform(click());
    }
    public void clickTheme(){
        onView(allOf(withText("App theme"), isDisplayed())).perform(click());
    }
    public void swipe(){
        onView(withId(android.R.id.content)).perform(ViewActions.swipeUp());
    }
    public void logOut(){
        onView(allOf(withId(R.id.logoutButton), isDisplayed())).perform(click());
    }
}
