package myNews.data.service.realAPI;

import androidx.annotation.Nullable;

import java.util.List;

import myNews.data.repositories.model.Articles;
import myNews.data.service.realAPI.articleSearch.articleSearchPOJO.ResponseOfArticleSearch;
import myNews.data.service.realAPI.mostPopular.MostPopularCalls;
import myNews.data.service.realAPI.mostPopular.mostPopularPOJO.ResponseOfMostPopular;
import myNews.data.service.realAPI.topStories.TopStoriesCalls;
import myNews.data.service.realAPI.topStories.topStoriesPOJO.ResponseOfTopStories;
import myNews.others.utils.UtilsForMostPopular;
import myNews.others.utils.UtilsForTopStories;
import myNews.view.activitiesAndFragment.FragmentArticles;
import retrofit2.Call;

/**
 * Created by Remy Pouzet on 17/12/2019.
 */
public class NytApiService extends FragmentArticles implements NytApiInterfaceService
{
    private static String section;
    private static String query;
    private static String filter;

    public static void setSection(String section)
    {
        NytApiService.section = section;
    }

    public static void setQuery(String query)
    {
        NytApiService.query = query;
    }

    public static void setFilter(String filter)
    {
        NytApiService.filter = filter;
    }

    public void callArticlesFromTopStories()
    {
        TopStoriesCalls.fetchTopStoriesResponseArticles(new TopStoriesCalls.Callbacks()
        {
            @Override
            public void onResponse(@Nullable ResponseOfTopStories articles)
            {
                List<Articles> articlesList = UtilsForTopStories.generateArticlesFromTopStories(articles);
                updateList(articlesList);
            }


            @Override
            public void onFailure()
            {

            }
        }, section);
    }

    public void callArticlesFromMostPopular()
    {
        MostPopularCalls.fetchMostPopularResponseArticles(new MostPopularCalls.Callbacks()
        {
            @Override
            public void onResponse(@Nullable ResponseOfMostPopular articles)
            {
                List<Articles> articlesList = UtilsForMostPopular.generateArticlesFromMostPopular(articles);
                updateList(articlesList);
            }


            @Override
            public void onFailure()
            {

            }
        });
    }

   /* public void callArticlesFromArticleSearch()
    {
        ArticleSearchCalls.fetchArticleSearchResponseArticles(new ArticleSearchCalls.Callbacks()
        {
           @Override
            public void onResponse(@Nullable ResponseOfArticleSearch articles)
            {
                List<Articles> articlesList = UtilsForArticleSearch.generateArticlesFromArticleSearch(articles);
                updateList(articlesList);
            }


            @Override
            public void onFailure()
            {

            }
        }, query, filter);
    }*/

    @Override
    public Call<ResponseOfTopStories> getResponseOfTopStories(String section)
    {
        return null;
    }

    @Override
    public Call<ResponseOfMostPopular> getResponseOfMostPopular()
    {
        return null;
    }

    @Override
    public Call<ResponseOfArticleSearch> getResponseOfArticleSearch(String query, String filter)
    {
        return null;
    }
}

