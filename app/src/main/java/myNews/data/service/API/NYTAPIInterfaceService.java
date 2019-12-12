package myNews.data.service.API;

import myNews.data.service.API.topStories.topStoriesPOJO.ResponseTopStories;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

import static myNews.Others.Constant.API_KEY;


/**
 * Created by Remy Pouzet on 05/12/2019.
 */
public interface NYTAPIInterfaceService
{
    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/svc/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET("topstories/v2/{section}.json?" + API_KEY)
    Call<ResponseTopStories> getFollowing(@Path("section") String section);

}
