package myNews.viewmodel;

import myNews.view.activitiesAndFragment.FragmentArticles;

/**
 * Created by Remy Pouzet on 05/12/2019.
 */
public class ViewModelMyNews extends androidx.lifecycle.ViewModel
{
    private int IdOfSelectedTab;

    public ViewModelMyNews(int position)
    {
        IdOfSelectedTab = position;
    }

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


