package myNews.others.utils;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import myNews.data.repositories.model.Articles;
import myNews.data.service.realAPI.topStories.topStoriesPOJO.ResponseOfTopStories;
import myNews.data.service.realAPI.topStories.topStoriesPOJO.ResultsItemOfTopStories;
import myNews.myNews.R;

/**
 * Created by Remy Pouzet on 09/12/2019.
 */

public class UtilsForTopStories {
    private static String publishedDateAdaptedForArticlesFormat;
    public static String multimediaUrl;

    public static List<Articles> generateArticlesFromTopStories(ResponseOfTopStories responseOfTopStories) {
        List<Articles> topStoriesArticles = new ArrayList<>();
        if (responseOfTopStories != null) {
            List<ResultsItemOfTopStories> resultsTopStories = responseOfTopStories.getResults();
            for (int x = 0; x <= resultsTopStories.size() - 1; x++)
                topStoriesArticles.add(addArticleFromTopStories(resultsTopStories.get(x)));
        }
        return topStoriesArticles;
    }

    private static Articles addArticleFromTopStories(ResultsItemOfTopStories resultsItemOfTopStories) {

        if (resultsItemOfTopStories.getMultimedia() != null) {
            multimediaUrl = resultsItemOfTopStories.getMultimedia().size() != 0 ? resultsItemOfTopStories.getMultimedia().get(0).getUrl() : "";
        } else {
            multimediaUrl = "";
        }

        @SuppressLint("SimpleDateFormat") SimpleDateFormat publishedDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        Date publishedDateInDateFormat;
        try {
            publishedDateInDateFormat = publishedDate.parse(resultsItemOfTopStories.getPublishedDate());
            @SuppressLint("SimpleDateFormat") DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            assert publishedDateInDateFormat != null;
            publishedDateAdaptedForArticlesFormat = dateFormat.format(publishedDateInDateFormat);
            System.out.println(publishedDateAdaptedForArticlesFormat);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Articles(R.drawable.test, multimediaUrl, resultsItemOfTopStories.getSection(), resultsItemOfTopStories.getSubsection(), resultsItemOfTopStories.getTitle(), publishedDateAdaptedForArticlesFormat);
    }
}






