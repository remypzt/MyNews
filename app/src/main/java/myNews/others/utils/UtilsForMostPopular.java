package myNews.others.utils;

import java.util.ArrayList;
import java.util.List;

import myNews.data.repositories.model.Articles;
import myNews.data.service.realAPI.mostPopular.mostPopularPOJO.ResponseOfMostPopular;
import myNews.data.service.realAPI.mostPopular.mostPopularPOJO.ResultsItemOfMostPopular;
import myNews.myNews.R;

/**
 * Created by Remy Pouzet on 16/12/2019.
 */
public class UtilsForMostPopular
{
    private static String publishedDateAdaptedForArticlesFormat;
    private static ResultsItemOfMostPopular mediaMetadataItemOfMostPopular;
    //TODO there is very probably something wrong about the way to get URL of articlePicture


    public static List<Articles> generateArticlesFromMostPopular(ResponseOfMostPopular responseOfMostPopular
    )
    {
        List<Articles> mostPopularArticles = new ArrayList<>();
        if (responseOfMostPopular != null)
        {
            List<ResultsItemOfMostPopular> resultsMostPopular = responseOfMostPopular.getResults();

            for (int x = 0; x <= resultsMostPopular.size() - 1; x++)
                mostPopularArticles.add(addArticleFromMostPopular(resultsMostPopular.get(x)));

        }
        return mostPopularArticles;
    }

    private static Articles addArticleFromMostPopular(ResultsItemOfMostPopular resultsItemOfMostPopular)
    {
       /* @SuppressLint("SimpleDateFormat") SimpleDateFormat publishedDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        Date publishedDateInDateFormat;
        try
        {
            publishedDateInDateFormat = publishedDate.parse(resultsItemOfMostPopular.getPublishedDate());
            @SuppressLint("SimpleDateFormat") DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            assert publishedDateInDateFormat != null;
            publishedDateAdaptedForArticlesFormat = dateFormat.format(publishedDateInDateFormat);
            System.out.println(publishedDateAdaptedForArticlesFormat);
        } catch (ParseException e)
        {
            e.printStackTrace();
        }*/


        return new Articles(R.drawable.test,
                "", "", "", "", "" /* for test */
                // mediaMetadataItemOfMostPopular.getUrl(),
                // resultsItemOfMostPopular.getSection(),
                //null/*there isn't subsection object for MostPopular*/,
                //resultsItemOfMostPopular.getTitle(),
                //publishedDateAdaptedForArticlesFormat
        );
    }
}
