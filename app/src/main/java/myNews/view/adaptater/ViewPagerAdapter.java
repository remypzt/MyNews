package myNews.view.adaptater;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import myNews.view.userInterface.Fragment1;
import myNews.view.userInterface.Fragment2;
import myNews.view.userInterface.Fragment3;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position ==0) {
            return new Fragment1();
        } else if (position == 1) {
            return new Fragment2();
        } else return new Fragment3();
    }

    @Override
    public int getCount() {
        return 3;
    }
}
