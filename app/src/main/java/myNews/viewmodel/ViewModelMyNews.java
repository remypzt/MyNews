package myNews.viewmodel;

import myNews.data.service.realAPI.NytApiService;

/**
 * Created by Remy Pouzet on 05/12/2019.
 */
public class ViewModelMyNews extends androidx.lifecycle.ViewModel
{
    NytApiService mNytApiService;
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
                mNytApiService.callArticlesFromTopStories();
                NytApiService.setSection("home");
                break;
            case 1:
                mNytApiService.callArticlesFromMostPopular();
                break;
            default:
                mNytApiService.callArticlesFromTopStories();
                NytApiService.setSection("arts");
        }
    }
}


