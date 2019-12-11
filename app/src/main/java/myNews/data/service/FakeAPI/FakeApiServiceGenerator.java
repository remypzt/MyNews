package myNews.data.service.FakeAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import myNews.data.repositories.model.Articles;
import myNews.data.service.API.topStories.topStoriesPOJO.ResultsItem;
import myNews.devexchanges.myNews.R;


/**
 * Created by Remy Pouzet on 25/11/2019.
 */
public class FakeApiServiceGenerator
{
    private static String title = new ResultsItem().getTitle();
    ;
    public static List<Articles> FAKE_ARTICLES = Arrays.asList(
            new Articles(R.drawable.test,
                    "https://upload.wikimedia.org/wikipedia/commons/d/d9/Test.png",
                    "categorie",
                    "sous categorie",
                    "titre",
                    "date"),
            new Articles(R.drawable.test,
                    "",
                    "categorie2",
                    "sous categorie2",
                    "" + title,
                    "date2")
    );

    static List<Articles> generateArticles()
    {
        return new ArrayList<>(FAKE_ARTICLES);
    }
}
