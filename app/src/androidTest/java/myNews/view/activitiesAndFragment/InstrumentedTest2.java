package myNews.view.activitiesAndFragment;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import myNews.myNews.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.swipeLeft;
import static androidx.test.espresso.action.ViewActions.swipeRight;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class InstrumentedTest2 {
	
	@Rule public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);
	
	@Test
	public void mainActivityTest2() {
		
		ViewInteraction textView = onView(allOf(withText("MOST POPULAR"), isDisplayed()));
		textView.check(matches(withText("MOST POPULAR")));
		
		ViewInteraction swipe = onView(withId(R.id.view_pager)).perform(swipeLeft());
		
		int i;
		i = mActivityTestRule.getActivity().viewPager.getCurrentItem();
		
		assertEquals("MOST POPULAR", mActivityTestRule.getActivity().viewPager
				.getAdapter()
				.getPageTitle(i)
				.toString());
		
	
	
		
	}
	
	@Test
	public void mainActivityTest3() {
		
		ViewInteraction textView = onView(allOf(withText("MOST POPULAR"), isDisplayed()));
		textView.check(matches(withText("MOST POPULAR")));
		
		ViewInteraction swipe  = onView(withId(R.id.view_pager)).perform(swipeLeft());
		ViewInteraction swipe2 = onView(withId(R.id.view_pager)).perform(swipeLeft());
		
		int i;
		i = mActivityTestRule.getActivity().viewPager.getCurrentItem();
		
		assertEquals("TECHNOLOGY", mActivityTestRule.getActivity().viewPager
				.getAdapter()
				.getPageTitle(i)
				.toString());
		
	}
	
	@Test
	public void mainActivityTest4() {
		
		ViewInteraction textView = onView(allOf(withText("MOST POPULAR"), isDisplayed()));
		textView.check(matches(withText("MOST POPULAR")));
		
		ViewInteraction swipe  = onView(withId(R.id.view_pager)).perform(swipeLeft());
		ViewInteraction swipe2 = onView(withId(R.id.view_pager)).perform(swipeLeft());
		ViewInteraction swipe3 = onView(withId(R.id.view_pager)).perform(swipeRight());
		ViewInteraction swipe4 = onView(withId(R.id.view_pager)).perform(swipeRight());
		
		int i;
		i = mActivityTestRule.getActivity().viewPager.getCurrentItem();
		
		assertEquals("TOP STORIES", mActivityTestRule.getActivity().viewPager
				.getAdapter()
				.getPageTitle(i)
				.toString());
		
	}
	
}
