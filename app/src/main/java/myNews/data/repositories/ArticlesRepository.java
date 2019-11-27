package myNews.data.repositories;

import java.util.List;

import myNews.data.repositories.model.Articles;
import myNews.data.service.API.ApiService;

/**
 * Created by Remy Pouzet on 25/11/2019.
 */
public class ArticlesRepository
{
    private final ApiService apiService;

    public ArticlesRepository(ApiService apiService)
    {
        this.apiService = apiService;
    }

    public List<Articles> getArticles()
    {
        return apiService.getArticles();



    }
}
