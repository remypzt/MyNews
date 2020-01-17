package myNews.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import myNews.data.repositories.NytApiRepository;
import myNews.data.repositories.model.Articles;
import myNews.view.activitiesAndFragment.SearchActivity;

/**
 * Created by Remy Pouzet on 14/01/2020.
 */
public class ViewModelMyNewsForSearchArticles extends androidx.lifecycle.ViewModel {

    private NytApiRepository mNytApiRepository;
    private SearchActivity mSearchActivity;
    private MutableLiveData<List<Articles>> mArticles;


    public ViewModelMyNewsForSearchArticles(String query, String filter, String beginDate, String endDate) {


        if (beginDate == null) {
            beginDate = "01012000";
        }

        if (endDate == null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
            String currentDate = sdf.format(new Date());

            beginDate = currentDate;
        }

        mArticles = mNytApiRepository.getSearchArticles(query, null, beginDate, endDate);
    }

    public LiveData<List<Articles>> getNews() {
        return mArticles;
    }
}


