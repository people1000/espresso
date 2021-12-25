package org.wikipedia.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressBack;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.matcher.ViewMatchers;

import org.hamcrest.Matchers;
import org.wikipedia.R;

public class ThemePage {
    public void choose(){
        onView(Matchers.allOf(ViewMatchers.withId(R.id.button_theme_sepia), isDisplayed())).perform(click());
    }
    public void back(){
        onView(allOf(withId(android.R.id.content), isDisplayed())).perform(pressBack());
    }
}
