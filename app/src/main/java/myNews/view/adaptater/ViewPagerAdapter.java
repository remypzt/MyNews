package myNews.view.adaptater;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import myNews.view.activitiesAndFragment.FragmentArticles;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public static int IdOfSelectedTab;

    public static int getIdOfSelectedTab()
    {
        return IdOfSelectedTab;
    }
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

    public void getIdofSelectedTab(int position)
    {
        if (position == 0)
        {
            IdOfSelectedTab = 0;
        } else if (position == 1)
        {
            IdOfSelectedTab = 1;
        } else
        {
            IdOfSelectedTab = 2;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
