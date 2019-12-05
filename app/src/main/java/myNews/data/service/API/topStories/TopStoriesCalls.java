package myNews.data.service.API.topStories;

import androidx.annotation.Nullable;

import java.lang.ref.WeakReference;
import java.util.List;

import myNews.data.repositories.model.Articles;
import myNews.data.service.API.TopStoriesService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Remy Pouzet on 05/12/2019.
 */
public class TopStoriesCalls
{

    // 2 - Public method to start fetching users following by Jake Wharton
    public static void fetchArtsArticles(Callbacks callbacks, String arts)
    {

        // 2.1 - Create a weak reference to callback (avoid memory leaks)
        final WeakReference<Callbacks> callbacksWeakReference = new WeakReference<Callbacks>(callbacks);

        // 2.2 - Get a Retrofit instance and the related endpoints
        TopStoriesService topStoriesService = TopStoriesService.retrofit.create(TopStoriesService.class);

        // 2.3 - Create the call on NYT API
        Call<List<Articles>> call = topStoriesService.getFollowing(arts);

        // 2.4 - Start the call
        call.enqueue(new Callback<List<Articles>>()
        {

            @Override
            public void onResponse(Call<List<Articles>> call, Response<List<Articles>> response)
            {
                // 2.5 - Call the proper callback used in controller (MainFragment)
                if (callbacksWeakReference.get() != null)
                    callbacksWeakReference.get().onResponse(response.body());
            }

            @Override
            public void onFailure(Call<List<Articles>> call, Throwable t)
            {
                // 2.5 - Call the proper callback used in controller (MainFragment)
                if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onFailure();
            }
        });
    }

    // 1 - Creating a callback
    public interface Callbacks
    {
        void onResponse(@Nullable List<Articles> articles);

        void onFailure();
    }
}
