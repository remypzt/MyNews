package myNews.data.service.FakeAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import myNews.data.repositories.model.Articles;


/**
 * Created by Remy Pouzet on 25/11/2019.
 */
public class FakeApiServiceGenerator
{
    public static List<Articles> FAKE_ARTICLES = Arrays.asList(
            new Articles("https://upload.wikimedia.org/wikipedia/commons/d/d9/Test.png", "categorie", "sous categorie", "titre", "date"),
            new Articles("", "categorie2", "sous categorie2", "titre2", "date2")
    );

    static List<Articles> generateArticles()
    {
        return new ArrayList<>(FAKE_ARTICLES);
    }
}
