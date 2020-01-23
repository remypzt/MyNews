package myNews.view.adaptater;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import myNews.view.activitiesAndFragment.FragmentArticles;

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
        } else return FragmentArticles.newInstance(position);
    }

    //= there is 3 tabs
    @Override
    public int getCount() {
        return 3;
    }

}
