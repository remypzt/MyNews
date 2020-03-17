package myNews;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import myNews.myNews.R;
import myNews.view.activitiesAndFragment.MainActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class InstrumentedTest {
	
	@Rule public final ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);
	// FOR DATA
	private            Context                        context;
	
	@Test
	public void useAppContext() {
		// Context of the app under test.
		Context appContext = InstrumentationRegistry
				.getInstrumentation()
				.getTargetContext();
		
		assertEquals("info.devexchanges.navvp", appContext.getPackageName());
	}
	
	@Before
	public void setup() {
		// this.context = InstrumentationRegistry.getTargetContext();
	}
	
	@Test
	public void testingSearchButtonDisplaying() {
		onView(withId(R.id.action_search)) // withId(R.id.my_button) is a ViewMatcher
		                                   .perform(click());// click() is a ViewAction
		onView(withId(R.id.constraintLayoutSearch)).check(matches(isDisplayed())); // matches(isDisplayed()) is a ViewAssertion
	}
	
}
    

