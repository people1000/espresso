package org.wikipedia.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.matcher.ViewMatchers;

import org.hamcrest.Matchers;
import org.wikipedia.R;

public class LoginPage {
    public void loginClick(){
        onView(Matchers.allOf(ViewMatchers.withId(R.id.create_account_login_button), isDisplayed())).perform(click());
    }
    public void username(){
        onView(allOf(withHint("Username"),isDisplayed())).perform(typeText("daria_1000"));
    }
    public void password(){
        onView(allOf(withHint("Password"), isDisplayed())).perform(typeText("Dasha_2001"));
    }
    public void loginButton(){
        onView(allOf(withId(R.id.login_button), isDisplayed())).perform(click());
    }
}
