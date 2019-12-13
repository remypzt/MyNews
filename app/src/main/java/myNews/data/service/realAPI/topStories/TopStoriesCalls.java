package myNews.data.service.realAPI.topStories;

import androidx.annotation.Nullable;

import myNews.data.service.realAPI.NytApiInterfaceService;
import myNews.data.service.realAPI.topStories.topStoriesPOJO.ResponseTopStories;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Remy Pouzet on 05/12/2019.
 */
public class TopStoriesCalls
{

    // 2 - Public method to start fetching Articles
    public static void fetchTopStoriesResponseArticles(Callbacks callbacks, String section)
    {

        // 2.1 - Create a weak reference to callback (avoid memory leaks)
        // final WeakReference<Callbacks> callbacksWeakReference = new WeakReference<Callbacks>(callbacks);

        // 2.2 - Get a Retrofit instance and the related endpoints
        NytApiInterfaceService nytapiInterfaceService = NytApiInterfaceService.retrofit.create(NytApiInterfaceService.class);

        // 2.3 - Create the call on NYT API
        //TODO maybe there is a mistake about getFollowing

        Call<ResponseTopStories> call = nytapiInterfaceService.getFollowing(section);

        // 2.4 - Start the call
        call.enqueue(new Callback<ResponseTopStories>()
        {

            @Override
            public void onResponse(Call<ResponseTopStories> call, Response<ResponseTopStories> response)
            {
                // 2.5 - Call the proper callback used in controller (MainFragment)
                callbacks.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<ResponseTopStories> call, Throwable t)
            {
                // 2.5 - Call the proper callback used in controller (MainFragment)
                callbacks.onFailure();
            }
        });
    }

    // 1 - Creating a callback
    public interface Callbacks
    {
        void onResponse(@Nullable ResponseTopStories articles);


        void onFailure();
    }
}
