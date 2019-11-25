package myNews.view.Base;

import myNews.data.Injection;
import myNews.data.repositories.ArticlesRepository;

/**
 * Created by Remy Pouzet on 25/11/2019.
 */
public class BaseFragment
{
    private ArticlesRepository articlesRepository;

    public ArticlesRepository getArticlesRepository()
    {
        if (articlesRepository == null) articlesRepository = Injection.createArticlesRepository();
        return articlesRepository;
    }
}
