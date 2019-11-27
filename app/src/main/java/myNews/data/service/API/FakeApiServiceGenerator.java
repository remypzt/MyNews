package myNews.data.service.API;

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
            new Articles("C:\\Users\\moi\\AndroidStudioProjects\\MyNews\\app\\src\\main\\res\\test.jpg", "categorie", "sous categorie", "titre", "date"),
            new Articles("C:\\Users\\moi\\AndroidStudioProjects\\MyNews\\app\\src\\main\\res\\test.jpg", "categorie", "sous categorie", "titre", "date1")
    );

    static List<Articles> generateArticles()
    {
        return new ArrayList<>(FAKE_ARTICLES);
    }
}
