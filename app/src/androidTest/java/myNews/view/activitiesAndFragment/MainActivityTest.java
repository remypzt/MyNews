package myNews.view.activitiesAndFragment;

/*
@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
	
	@Rule public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);
	
	@Test
	public void mainActivityTest() {
		mActivityTestRule.getActivity()
		                 .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
		;
		
		//onView(withId(R.id.menuNotifications)).perform(click());
		
		ViewInteraction overflowMenuButton = onView(allOf(withContentDescription("More options"), childAtPosition(childAtPosition(withId(R.id.toolbar), 0), 1), isDisplayed()));
		overflowMenuButton.perform(click());
		
		ViewInteraction appCompatTextView = onView(allOf(withId(R.id.title), withText("Notification"), childAtPosition(childAtPosition(withId(R.id.content), 0), 0), isDisplayed()));
		appCompatTextView.perform(click());
		
		
		ViewInteraction viewGroup = onView(allOf(withId(R.id.parentConstraintLayoutOfNotifications), childAtPosition(allOf(withId(R.id.constraintLayout), childAtPosition(withId(android.R.id.content), 0)), 1), isDisplayed()));
		viewGroup.check(matches(isDisplayed()));
	}
	
	private static Matcher<View> childAtPosition(final Matcher<View> parentMatcher,
	                                             final int position) {
		
		return new TypeSafeMatcher<View>() {
			@Override
			public void describeTo(Description description) {
				description.appendText("Child at position " + position + " in parent ");
				parentMatcher.describeTo(description);
			}
			
			@Override
			public boolean matchesSafely(View view) {
				ViewParent parent = view.getParent();
				return parent instanceof ViewGroup && parentMatcher.matches(parent) && view.equals(((ViewGroup) parent).getChildAt(position));
			}
		};
	}
	
}*/
