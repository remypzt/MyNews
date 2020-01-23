package myNews.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import myNews.data.repositories.NytApiRepository;
import myNews.data.repositories.model.Articles;

/**
 * Created by Remy Pouzet on 05/12/2019.
 */

public class ViewModelMyNews extends androidx.lifecycle.ViewModel {
    private NytApiRepository mNytApiRepository;
    private MutableLiveData<List<Articles>> mArticles;
    private int IdOfSelectedTab;

    public ViewModelMyNews(int position) {
        IdOfSelectedTab = position;
        mNytApiRepository = NytApiRepository.getInstance();

        switch (IdOfSelectedTab) {
            case 0:
                mArticles = mNytApiRepository.getTopStories("home");
                break;
            case 1:
                mArticles = mNytApiRepository.getMostPopular();
                break;
            case 2:
                mArticles = mNytApiRepository.getTopStories("technology");
                break;

        }
    }

    public LiveData<List<Articles>> getNews() {
        return mArticles;
    }
}


