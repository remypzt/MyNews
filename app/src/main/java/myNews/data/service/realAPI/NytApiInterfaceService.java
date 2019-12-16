package myNews.data.service.realAPI;

import myNews.data.service.realAPI.articleSearch.articleSearchPOJO.ResponseOfArticleSearch;
import myNews.data.service.realAPI.mostPopular.mostPopularPOJO.ResponseOfMostPopular;
import myNews.data.service.realAPI.topStories.topStoriesPOJO.ResponseOfTopStories;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

import static myNews.others.Constant.API_KEY;


/**
 * Created by Remy Pouzet on 05/12/2019.
 */
public interface NytApiInterfaceService
{
    //Interface elements are public static and final
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/svc/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET("topstories/v2/{section}.json?" + API_KEY)
    Call<ResponseOfTopStories> getResponseOfTopStories(@Path("section") String section);

    @GET("mostpopular/v2/viewed/7.json?" + API_KEY)
    Call<ResponseOfMostPopular> getResponseOfMostPopular(@Path("") String nothing);

    @GET("search/v2/articlesearch.json?q={query}&fq={filter}" + API_KEY)
    Call<ResponseOfArticleSearch> getResponseOfArticleSearch(@Path("query") String query, @Path("filter") String filter);

}
