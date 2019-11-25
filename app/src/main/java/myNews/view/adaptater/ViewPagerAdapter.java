package myNews.view.adaptater;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import myNews.view.userInterface.FragmentArticles;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position ==0) {
            return new FragmentArticles();
        } else if (position == 1) {
            return new FragmentArticles();
        } else return new FragmentArticles();
    }

    @Override
    public int getCount() {
        return 3;
    }
}
