package myNews.data.service.realAPI.articleSearch;

import androidx.annotation.Nullable;

import myNews.data.service.realAPI.NytApiInterfaceService;
import myNews.data.service.realAPI.articleSearch.articleSearchPOJO.ResponseOfArticleSearch;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Remy Pouzet on 16/12/2019.
 */
public class ArticleSearchCalls
{
    // 2 - Public method to start fetching Articles
    public static void fetchArticleSearchResponseArticles(ArticleSearchCalls.Callbacks callbacks, String query, String filter)
    {

        // 2.1 - Create a weak reference to callback (avoid memory leaks)
        // final WeakReference<Callbacks> callbacksWeakReference = new WeakReference<Callbacks>(callbacks);

        // 2.2 - Get a Retrofit instance and the related endpoints
        NytApiInterfaceService nytapiInterfaceService = NytApiInterfaceService.retrofit.create(NytApiInterfaceService.class);

        // 2.3 - Create the call on NYT API
        //TODO maybe there is a mistake about getResponseOfArticle

        Call<ResponseOfArticleSearch> call = nytapiInterfaceService.getResponseOfArticleSearch(query, filter);

        // 2.4 - Start the call
        call.enqueue(new Callback<ResponseOfArticleSearch>()
        {

            @Override
            public void onResponse(Call<ResponseOfArticleSearch> call, Response<ResponseOfArticleSearch> response)
            {
                // 2.5 - Call the proper callback used in controller (MainFragment)
                callbacks.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<ResponseOfArticleSearch> call, Throwable t)
            {
                // 2.5 - Call the proper callback used in controller (MainFragment)
                callbacks.onFailure();
            }
        });
    }

    // 1 - Creating a callback
    public interface Callbacks
    {
        void onResponse(@Nullable ResponseOfArticleSearch articles);


        void onFailure();
    }
}
