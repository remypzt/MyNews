package myNews.others.utils;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import myNews.data.repositories.model.Articles;
import myNews.data.service.realAPI.articleSearch.articleSearchPOJO.Doc;
import myNews.data.service.realAPI.articleSearch.articleSearchPOJO.Response;
import myNews.data.service.realAPI.articleSearch.articleSearchPOJO.ResponseOfArticleSearch;
import myNews.myNews.R;

/**
 * Created by Remy Pouzet on 16/12/2019.
 */
public class UtilsForArticleSearch {
	static Date publishedDateInDateFormat;
	
	public static List<Articles> generateArticlesFromArticleSearch(ResponseOfArticleSearch responseOfArticleSearch) {
		List<Articles> articleSearchArticles = new ArrayList<>();
		if (responseOfArticleSearch != null) {
			Response resultsArticleSearch = responseOfArticleSearch.getResponse();
			for (int x = 0;
			     x <= resultsArticleSearch
					          .getDocs()
					          .size() - 1;
			     x++) {
				articleSearchArticles.add(addArticleFromArticleSearch(resultsArticleSearch
						                                                      .getDocs()
						                                                      .get(x)));
			}
			
		}
		return articleSearchArticles;
	}
	
	private static Articles addArticleFromArticleSearch(Doc responseOfArticleSearch) {
		String multimediaUrl = responseOfArticleSearch
				                       .getMultimedia()
				                       .size() != 0
		                       ? responseOfArticleSearch
				                       .getMultimedia()
				                       .get(0)
				                       .getUrl()
		                       : "";
		
		@SuppressLint("SimpleDateFormat") SimpleDateFormat publishedDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
		
		try {
			publishedDateInDateFormat = publishedDate.parse(responseOfArticleSearch.getPubDate());
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		@SuppressLint("SimpleDateFormat") DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		String localPublishedDateAdaptedForArticlesFormat = dateFormat.format(publishedDateInDateFormat);
		
		return new Articles(R.drawable.test, multimediaUrl, responseOfArticleSearch.getSectionName(), "", responseOfArticleSearch
				.getHeadline()
				.getMain(), localPublishedDateAdaptedForArticlesFormat, responseOfArticleSearch.getWebUrl());
	}
	
}

