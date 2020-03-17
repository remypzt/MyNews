package myNews.view.adaptater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import myNews.view.activitiesAndFragment.FragmentArticles;

@SuppressWarnings("ALL")
public class ViewPagerAdapter extends FragmentPagerAdapter {
	public ViewPagerAdapter(FragmentManager fm) {
		super(fm);
	}
	
	@NonNull
	@Override
	public Fragment getItem(int position) {
		
		if (position == 0) {
			return FragmentArticles.newInstance(position);
		} else if (position == 1) {
			return FragmentArticles.newInstance(position);
		} else {
			return FragmentArticles.newInstance(position);
		}
	}
	
	@Nullable
	@Override
	public CharSequence getPageTitle(int position) {
		String title;
		
		if (position == 0) {
			title = "TOP STORIES";
			return title;
		} else if (position == 1) {
			title = "MOST POPULAR";
			return title;
		} else {
			title = "TECHNOLOGY";
			return title;
		}
		
	}
	
	//= there is 3 tabs
	@Override
	public int getCount() {
		return 3;
	}
	
}
