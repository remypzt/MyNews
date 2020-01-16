package myNews.data.service.realAPI;

import myNews.data.service.realAPI.mostPopular.mostPopularPOJO.ResponseOfMostPopular;
import myNews.data.service.realAPI.topStories.topStoriesPOJO.ResponseOfTopStories;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static myNews.others.Constant.API_KEY;


/**
 * Created by Remy Pouzet on 05/12/2019.
 */
public interface NytApiInterfaceService {
    @GET("topstories/v2/{section}.json?" + API_KEY)
    Call<ResponseOfTopStories> getResponseOfTopStories(@Path("section") String section);

    @GET("mostpopular/v2/viewed/7.json?" + API_KEY)
    Call<ResponseOfMostPopular> getResponseOfMostPopular();

    @GET("search/v2/articlesearch.json?" + API_KEY)
    Call<ResponseOfArticleSearch> getResponseOfArticleSearch(@Query("q") String query, @Query("fq") String filter, @Query("begin_date") String beginDate, @Query("end_date") String endDate);

}
