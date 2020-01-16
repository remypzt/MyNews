package myNews.data.repositories;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import myNews.data.repositories.model.Articles;
import myNews.data.service.realAPI.NytApiInterfaceService;
import myNews.data.service.realAPI.RetrofitService;
import myNews.data.service.realAPI.mostPopular.mostPopularPOJO.ResponseOfMostPopular;
import myNews.data.service.realAPI.topStories.topStoriesPOJO.ResponseOfTopStories;
import myNews.others.utils.UtilsForMostPopular;
import myNews.others.utils.UtilsForTopStories;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Remy Pouzet on 17/12/2019.
 */
public class NytApiRepository {
    private static NytApiRepository nytApiRepository;
    private final NytApiInterfaceService mNytApiInterfaceService;

    private NytApiRepository() {
        mNytApiInterfaceService = RetrofitService.cteateService(NytApiInterfaceService.class);
    }

    public static NytApiRepository getInstance() {
        if (nytApiRepository == null) {
            nytApiRepository = new NytApiRepository();
        }
        return nytApiRepository;
    }

    public MutableLiveData<List<Articles>> getTopStories(String section) {
        MutableLiveData<List<Articles>> topStories = new MutableLiveData<>();
        mNytApiInterfaceService.getResponseOfTopStories(section).enqueue(new Callback<ResponseOfTopStories>() {
            @Override
            public void onResponse(Call<ResponseOfTopStories> call, Response<ResponseOfTopStories> response) {
                if (response.isSuccessful()) {
                    topStories.setValue(UtilsForTopStories.generateArticlesFromTopStories(response.body()));
                } else {
                    topStories.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<ResponseOfTopStories> call, Throwable t) {
                topStories.setValue(null);
            }
        });
        return topStories;
    }

    public MutableLiveData<List<Articles>> getMostPopular() {
        MutableLiveData<List<Articles>> mostPopular = new MutableLiveData<>();
        mNytApiInterfaceService.getResponseOfMostPopular().enqueue(new Callback<ResponseOfMostPopular>() {
            @Override
            public void onResponse(Call<ResponseOfMostPopular> call, Response<ResponseOfMostPopular> response) {
                if (response.isSuccessful()) {
                    mostPopular.setValue(UtilsForMostPopular.generateArticlesFromMostPopular(response.body()));
                } else {
                    mostPopular.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<ResponseOfMostPopular> call, Throwable t) {
                mostPopular.setValue(null);
            }
        });
        return mostPopular;
    }

    /*public MutableLiveData<List<Articles>> getSearchArticles(String query, String filter, String beginDate, String endDate) {
        MutableLiveData<List<Articles>> searchArticles = new MutableLiveData<>();
        mNytApiInterfaceService.getResponseOfArticleSearch(query, filter, beginDate, endDate).enqueue(new Callback<ResponseOfArticleSearch>() {
            @Override
            public void onResponse(Call<ResponseOfArticleSearch> call, Response<ResponseOfArticleSearch> response) {
                if (response.isSuccessful()) {
                    searchArticles.setValue(UtilsForArticleSearch.generateArticlesFromArticleSearch(response.body()));
                } else {
                    searchArticles.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<ResponseOfArticleSearch> call, Throwable t) {
                searchArticles.setValue(null);
            }
        });
        return searchArticles;
    }*/


}

