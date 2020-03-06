package myNews;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import myNews.data.repositories.model.Articles;
import myNews.data.service.realAPI.topStories.topStoriesPOJO.ResponseOfTopStories;
import myNews.data.service.realAPI.topStories.topStoriesPOJO.ResultsItemOfTopStories;
import myNews.others.utils.Utils;
import myNews.others.utils.UtilsForTopStories;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnit4.class)
public class UnitTest {
	
	@Test
	public void testingUIformat() {
		assertEquals("1/1/2020", Utils.UIformat(1, 0, 2020));
	}
	
	@Test
	public void testingBEdateFormat() {
		assertEquals("20200110", Utils.BEformat(10, 0, 2020));
	}
	
	@Test
	public void testingBEdateFormatException() {
		assertEquals("20200101", Utils.BEformatException(1, 0, 2020));
	}
	
	@Test
	public void testingGenerateArticlesFromTopStories() {
		ResponseOfTopStories    localResponseOfTopStories    = new ResponseOfTopStories();
		ResultsItemOfTopStories localResultsItemOfTopStories = new ResultsItemOfTopStories();
		//localResultsItemOfTopStories.getMultimedia().get(0).setUrl("multimediaUrl");
		localResultsItemOfTopStories.setSection("Test");
		localResultsItemOfTopStories.setSubsection("subsection");
		localResultsItemOfTopStories.setTitle("Title");
		localResultsItemOfTopStories.setPublishedDate("1999-03-22T05:06:07+01:00");
		localResultsItemOfTopStories.setUrl("url");
		List<ResultsItemOfTopStories> localListResultsTopStories = new ArrayList<>();
		localListResultsTopStories.add(localResultsItemOfTopStories);
		localResponseOfTopStories.setResults(localListResultsTopStories);
		List<Articles> localListFromTopStoriesArticles = UtilsForTopStories.generateArticlesFromTopStories(localResponseOfTopStories);
		assertEquals("Test", localListFromTopStoriesArticles
				.get(0)
				.getCategory());
		assertEquals(1, localListFromTopStoriesArticles.size());
		assertEquals("subsection", localListFromTopStoriesArticles
				.get(0)
				.getUnderCategory());
	}
}

