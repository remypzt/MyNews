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
	private MutableLiveData<List<Articles>> mArticles;
	
	public ViewModelMyNews(int position) {
		NytApiRepository localNytApiRepository = NytApiRepository.getInstance();
		
		switch (position) {
			case 0:
				mArticles = localNytApiRepository.getTopStories("home");
				break;
			case 1:
				mArticles = localNytApiRepository.getMostPopular();
				break;
			case 2:
				mArticles = localNytApiRepository.getTopStories("technology");
				break;
			
		}
	}
	
	public LiveData<List<Articles>> getNews() {
		return mArticles;
	}
}


