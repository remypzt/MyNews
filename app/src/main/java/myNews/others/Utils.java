package myNews.others;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import myNews.data.repositories.model.Articles;
import myNews.data.service.realAPI.topStories.topStoriesPOJO.ResponseTopStories;
import myNews.data.service.realAPI.topStories.topStoriesPOJO.ResultsItem;
import myNews.myNews.R;


/**
 * Created by Remy Pouzet on 09/12/2019.
 */
public class Utils
{
    private static String publishedDateAdaptedForArticlesFormat;


    public static List<Articles> generateArticlesFromTopStories(ResponseTopStories responseTopStories)
    {
        List<Articles> articles = new ArrayList<>();
        if (responseTopStories != null)
        {
            List<ResultsItem> resultsTopStories = responseTopStories.getResults();

            for (int x = 0; x <= resultsTopStories.size() - 1; x++)
                articles.add(addArticleFromTopStories(resultsTopStories.get(x)));

        }
        return articles;
    }

    private static Articles addArticleFromTopStories(ResultsItem resultsItem)
    {
        String multimediaUrl = resultsItem.getMultimedia().size() != 0 ? resultsItem.getMultimedia().get(0).getUrl() : "";

        @SuppressLint("SimpleDateFormat") SimpleDateFormat publishedDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        // Why publishedDateInDateFormat is null ???
        Date publishedDateInDateFormat;
        try
        {
            publishedDateInDateFormat = publishedDate.parse(resultsItem.getPublishedDate());
            @SuppressLint("SimpleDateFormat") DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            assert publishedDateInDateFormat != null;
            publishedDateAdaptedForArticlesFormat = dateFormat.format(publishedDateInDateFormat);
            System.out.println(publishedDateAdaptedForArticlesFormat);
        } catch (ParseException e)
        {
            e.printStackTrace();
        }


        return new Articles(R.drawable.test, multimediaUrl, resultsItem.getSection(),
                resultsItem.getSubsection(), resultsItem.getTitle(), publishedDateAdaptedForArticlesFormat);
    }
}






