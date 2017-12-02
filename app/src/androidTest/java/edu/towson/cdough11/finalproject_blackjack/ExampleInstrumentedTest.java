package edu.towson.cdough11.finalproject_blackjack;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static edu.towson.cdough11.finalproject_blackjack.R.id.action_menu_presenter;
//import static edu.towson.cdough11.finalproject_blackjack.R.id.betAmounts;
import static edu.towson.cdough11.finalproject_blackjack.R.id.dealCardsButton;
import static edu.towson.cdough11.finalproject_blackjack.R.id.hit;
import static edu.towson.cdough11.finalproject_blackjack.R.id.recyclerView;
import static edu.towson.cdough11.finalproject_blackjack.R.id.stay;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Rule
    public ActivityTestRule<GameActivity> gActivityRule =
            new ActivityTestRule<>(GameActivity.class);
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);
    @Rule
    public ActivityTestRule<SetBetActivity> bActivityRule =
            new ActivityTestRule<>(SetBetActivity.class);


    @Test
    public void RecyclerViewDisplayed(){
        onView(withId(recyclerView)).check(matches(isDisplayed()));
    }

    @Test
    public void PlayGameBtnDisplayed(){
        onView(withText("Play Game")).check(matches(isDisplayed()));
    }

    @Test
    public void DealBtnDisplayed(){
        onView(withId(dealCardsButton)).check(matches(isDisplayed()));
    }

    @Test
    public void HitBtnDisplayed(){
        onView(withId(hit)).check(matches(isDisplayed()));
    }

    @Test
    public void StayBtnDisplayed(){
        onView(withId(stay)).check(matches(isDisplayed()));
    }

    @Test
    public void HitBtnClick(){
        onView(withId(hit)).perform(click());
        onView(withId(recyclerView)).check(matches(isDisplayed()));
    }

   // @Test
    //public void BetAmountsDisplayed(){
    //    onView(withId(betAmounts)).check(matches(isDisplayed()));
    //}
}
