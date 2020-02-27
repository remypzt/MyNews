package myNews.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import myNews.data.repositories.NytApiRepository;
import myNews.data.repositories.model.Articles;

/**
 * Created by Remy Pouzet on 14/01/2020.
 */
public class ViewModelMyNewsForSearchArticles extends androidx.lifecycle.ViewModel {
	
	private MutableLiveData<List<Articles>> mArticles;
	
	public ViewModelMyNewsForSearchArticles(String query,
	                                        String filter,
	                                        String beginDate,
	                                        String endDate) {
		
		NytApiRepository localNytApiRepository = NytApiRepository.getInstance();
		
		mArticles = localNytApiRepository.getSearchArticles(query, filter, beginDate, endDate);
	}
	
	public LiveData<List<Articles>> getNews() {
		return mArticles;
	}
}


