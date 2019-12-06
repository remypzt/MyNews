package myNews.data.service.API;

import java.util.List;

import myNews.data.service.API.topStories.topStoriesPOJO.ResponseTopStories;
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
    final String API_KEY = "api-key=tGTrUuWczkuqWkLodwuXPqGprAUDTymQ";

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/svc/topstories/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET("{section}.json?" + API_KEY)
    Call<List<ResponseTopStories>> getFollowing(@Path("section") String section);
}
