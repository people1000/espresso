package org.wikipedia;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;

import org.hamcrest.Matcher;

import java.util.concurrent.TimeUnit;

public class TestUtil {
    public static void delay(long sec) {
        onView(isRoot()).perform(waitOnId(TimeUnit.SECONDS.toMillis(sec)));
    }

    private static ViewAction waitOnId(long millis)
    {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints()
            {
                return isRoot();
            }

            @Override
            public String getDescription()
            {
                return "Wait a specified amount of time.";
            }

            @Override
            public void perform(UiController uiController, View view)
            {
                uiController.loopMainThreadForAtLeast(millis);
            }
        };
    }

    public static Activity getActivity() {
        final Activity[] activity = new Activity[1];

        onView(isRoot()).check((view, noViewFoundException) -> {

            View checkedView = view;

            while (checkedView instanceof ViewGroup && ((ViewGroup) checkedView).getChildCount() > 0) {

                checkedView = ((ViewGroup) checkedView).getChildAt(0);

                if (checkedView.getContext() instanceof Activity) {
                    activity[0] = (Activity) checkedView.getContext();
                    return;
                }
            }
        });
        return activity[0];
    }
}
