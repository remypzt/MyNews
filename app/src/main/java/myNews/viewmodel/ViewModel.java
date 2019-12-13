package myNews.viewmodel;

import myNews.view.activitiesAndFragment.FragmentArticles;
import myNews.view.adaptater.ViewPagerAdapter;

/**
 * Created by Remy Pouzet on 05/12/2019.
 */
public class ViewModel extends androidx.lifecycle.ViewModel
{
    static int IdOfSelectedTab = ViewPagerAdapter.getIdOfSelectedTab();

    public void displayingAppropriateListOfArticles()
    {
        switch (IdOfSelectedTab)
        {
            case 0:
                FragmentArticles.setSection("home");
                break;
            /*case 1:
                Mostpopular;
                break;*/
            default:
                FragmentArticles.setSection("arts");
        }
    }
}


