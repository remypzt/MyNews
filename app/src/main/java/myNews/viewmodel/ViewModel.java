package myNews.viewmodel;

import myNews.data.Injection;
import myNews.data.repositories.ArticlesRepository;

/**
 * Created by Remy Pouzet on 05/12/2019.
 */
public class ViewModel extends androidx.lifecycle.ViewModel
{
    protected ArticlesRepository articlesRepository;

    public ViewModel()
    {
        if (articlesRepository == null) articlesRepository = Injection.createArticlesRepository();
        this.articlesRepository = articlesRepository;
    }

    public ArticlesRepository getArticlesRepository()
    {

        return articlesRepository;

    }

    // Simplified idea to manage tabs displaying
   /* public List<Articles> displayingAppropriateListOfArticles(){

        switch (MainActivity.gettabselected)
        {
            case R.id.0:
                TopStories;
                break;
            case R.id.1:
                Mostpopular;
                break;
            default:
                Buisness;
        }
     Simplified idea to manage tabs displaying

}
*/
}
