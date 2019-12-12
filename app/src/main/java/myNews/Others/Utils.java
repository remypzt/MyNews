package myNews.Others;

import java.util.ArrayList;
import java.util.List;

import myNews.data.repositories.model.Articles;
import myNews.data.service.API.topStories.topStoriesPOJO.ResponseTopStories;
import myNews.data.service.API.topStories.topStoriesPOJO.ResultsItem;
import myNews.devexchanges.myNews.R;


/**
 * Created by Remy Pouzet on 09/12/2019.
 */
public class Utils
{
    private static List<Articles> articles = new ArrayList<>();
    private static int sizeOfArticlesList = articles.size();

    public static List<Articles> generateArticlesFromTopStories(ResponseTopStories responseTopStories)
    {
        if (responseTopStories != null)
        {
            List<ResultsItem> resultsTopStories = responseTopStories.getResults();

            for (int x = sizeOfArticlesList; x <= resultsTopStories.size() && x <= 20; x++)
                articles.add(addArticleFromTopStories(resultsTopStories.get(x)));

        }
        return articles;
    }

    private static Articles addArticleFromTopStories(ResultsItem resultsItem)
    {
        String multimediaUrl = resultsItem.getMultimedia().size() != 0 ? resultsItem.getMultimedia().get(sizeOfArticlesList).getUrl() : "";

        return new Articles(R.drawable.test, multimediaUrl, resultsItem.getSection(),
                resultsItem.getSubsection(), resultsItem.getTitle(), resultsItem.getPublishedDate());
    }
}






