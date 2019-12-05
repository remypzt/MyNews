package myNews.data.service;

import java.util.List;

import myNews.data.repositories.model.Articles;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Remy Pouzet on 05/12/2019.
 */
public interface TopStoriesService
{
    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/svc/topstories/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    // maybe I'll must replace Articles by ResultsItem or by perfacet method and
    // and Perhaps I'll must add ".json" to "arts"

    @GET("arts")
    Call<List<Articles>> getFollowing(@Path("arts") String articles);
}
