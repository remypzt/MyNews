package myNews.view.adaptater;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import myNews.view.userInterface.FragmentMain;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position ==0) {
            return new FragmentMain();
        } else if (position == 1) {
            return new FragmentMain();
        } else return new FragmentMain();
    }

    @Override
    public int getCount() {
        return 3;
    }
}
