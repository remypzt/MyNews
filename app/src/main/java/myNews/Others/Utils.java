package myNews.Others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import myNews.data.repositories.model.Articles;
import myNews.data.service.API.topStories.topStoriesPOJO.MultimediaItem;
import myNews.data.service.API.topStories.topStoriesPOJO.ResponseTopStories;
import myNews.data.service.API.topStories.topStoriesPOJO.ResultsItem;
import myNews.devexchanges.myNews.R;


/**
 * Created by Remy Pouzet on 09/12/2019.
 */
public class Utils
{
    private static ResponseTopStories mResponseTopStories = new ResponseTopStories();
    private static List mResults = mResponseTopStories.getResults();
    private static int mSize = mResults.size();
    private static List<Articles> ARTICLES = Arrays.asList();


    private static Articles mArticlesItems = new Articles(
            R.drawable.test,
            new MultimediaItem().getUrl(),
            new ResultsItem().getSection(),
            new ResultsItem().getSubsection(),
            new ResultsItem().getTitle(),
            new ResultsItem().getPublishedDate()
    );


    public static void addingAllArticles()
    {
        while (ARTICLES.size() <= mSize)
        {
            addingArticles();
        }
    }

    private static void addingArticles()
    {
        ARTICLES.add(ARTICLES.size() + 1, mArticlesItems);
    }

    public static List<Articles> generateArticles()
    {
        return new ArrayList<>(ARTICLES);
    }

}
