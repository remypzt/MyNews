package myNews.others.utils;


import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import myNews.data.repositories.model.Articles;
import myNews.data.service.realAPI.articleSearch.articleSearchPOJO.DocsItemOfArticleSearch;
import myNews.data.service.realAPI.articleSearch.articleSearchPOJO.ResponseOfArticleSearch;
import myNews.myNews.R;

/**
 * Created by Remy Pouzet on 16/12/2019.
 */
public class UtilsForArticleSearch {
    private static String publishedDateAdaptedForArticlesFormat;

    public static List<Articles> generateArticlesFromArticleSearch(ResponseOfArticleSearch responseOfArticleSearch) {
        List<Articles> articleSearchArticles = new ArrayList<>();
        if (responseOfArticleSearch != null) {
            ResponseOfArticleSearch resultsArticleSearch = responseOfArticleSearch.getResponseOfArticleSearch();
            for (int x = 0; x <= resultsArticleSearch.getDocs().size() - 1; x++)
                articleSearchArticles.add(addArticleFromArticleSearch(resultsArticleSearch.getDocs().get(x)));

        }
        return articleSearchArticles;
    }

    private static Articles addArticleFromArticleSearch(DocsItemOfArticleSearch responseOfArticleSearch) {
        String multimediaUrl = responseOfArticleSearch.getMultimedia().size() != 0 ? responseOfArticleSearch.getMultimedia().get(0).getUrl() : "";
        @SuppressLint("SimpleDateFormat") SimpleDateFormat publishedDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        Date publishedDateInDateFormat;
        try {
            publishedDateInDateFormat = publishedDate.parse(responseOfArticleSearch.getPubDate());
            @SuppressLint("SimpleDateFormat") DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            assert publishedDateInDateFormat != null;
            publishedDateAdaptedForArticlesFormat = dateFormat.format(publishedDateInDateFormat);
            System.out.println(publishedDateAdaptedForArticlesFormat);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Articles(R.drawable.test, multimediaUrl, responseOfArticleSearch.getSectionName(), responseOfArticleSearch.getSubsectionName(), responseOfArticleSearch.getBylineOfArticleSearch().getPerson().get(0).getTitle().toString(), publishedDateAdaptedForArticlesFormat);
    }

}

