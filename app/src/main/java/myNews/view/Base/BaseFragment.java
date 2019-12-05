package myNews.view.Base;

import androidx.fragment.app.Fragment;

import myNews.data.Injection;
import myNews.data.repositories.ArticlesRepository;

/**
 * Created by Remy Pouzet on 25/11/2019.
 */
public class BaseFragment extends Fragment
{
    protected ArticlesRepository articlesRepository;

    public BaseFragment()
    {
        if (articlesRepository == null) articlesRepository = Injection.createArticlesRepository();
        this.articlesRepository = articlesRepository;
    }

    public ArticlesRepository getArticlesRepository()
    {

        return articlesRepository;

    }
}
