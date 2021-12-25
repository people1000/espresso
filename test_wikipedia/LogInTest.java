package org.wikipedia;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wikipedia.main.MainActivity;
import org.wikipedia.pages.LoginPage;
import org.wikipedia.pages.MainPage;
import org.wikipedia.pages.SettingsPage;
import org.wikipedia.pages.ThemePage;
import org.wikipedia.pages.SkipPage;
import org.wikipedia.settings.SettingsActivity;

@RunWith(AndroidJUnit4.class)
public class LogInTest {
    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    LoginPage loginPage;
    MainPage mainPage;
    SettingsPage settingsPage;
    ThemePage themePage;
    SkipPage skipPage;

    @Before
    public void initialize() {
        loginPage = new LoginPage();
        mainPage = new MainPage();
        settingsPage = new SettingsPage();
        themePage = new ThemePage();
        skipPage = new SkipPage();
    }

    @Test
    public void login() throws InterruptedException {
        skipPage.skipMessage();
        mainPage.clickNavMore();
        settingsPage.logIn();
        loginPage.loginClick();
        loginPage.username();
        loginPage.password();
        loginPage.loginButton();
        TestUtil.delay(5);
        skipPage.skipThanks();
        Assert.assertTrue(TestUtil.getActivity().getClass().equals(MainActivity.class));
    }

    @Test
    public void theme() throws InterruptedException {
        skipPage.skipMessage();
        mainPage.clickNavMore();
        settingsPage.clickSettings();
        settingsPage.clickTheme();
        themePage.choose();
        themePage.back();
        Assert.assertTrue(TestUtil.getActivity().getClass().equals(SettingsActivity.class));
        onView(allOf(withText("Sepia"))).check(matches(isDisplayed()));
    }

    @Test
    public void out() {
        skipPage.skipMessage();
        mainPage.clickNavMore();
        settingsPage.clickSettings();
        settingsPage.swipe();
        settingsPage.logOut();
        skipPage.skipLogout();
        onView(withText(R.string.toast_logout_complete)).check(matches(isDisplayed()));
        Assert.assertTrue(TestUtil.getActivity().getClass().equals(MainActivity.class));
    }
}
