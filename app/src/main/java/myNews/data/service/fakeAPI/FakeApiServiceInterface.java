package myNews.data.service.fakeAPI;

import java.util.List;

import myNews.data.repositories.model.Articles;

/**
 * Created by Remy Pouzet on 25/11/2019.
 */
public interface FakeApiServiceInterface {
	List<Articles> getArticles();
}

