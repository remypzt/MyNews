package myNews;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import myNews.others.utils.Utils;

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
	public void testingGenerateArticlesFromArticlesSearch() {
		
		//assertEquals("images/2020/02/29/multimedia/29sp-tefaflede-inyt1/29sp-tefaflede-inyt1-articleLarge.jpg",
		            
		             
		             /* new ViewModelMyNewsForSearchArticles("banana", "Arts", "20200227", "20200227")
				             .getNews()
				             .getValue()
				             .get(0)
				             .getUrlImage());
		             
		          /*   NytApiRepository
				.getInstance()
				.getSearchArticles("banana", "Business", "20200227", "20200227")
				.getValue()
				.get(1)
				.getUrlImage());
		*/
	}
	
	  /* @Test
    public void testingGenerateArticlesFromArticlesSearch (){
        assertEquals((R.drawable.test,
                     "images/2020/02/29/multimedia/29sp-tefaflede-inyt1/29sp-tefaflede-inyt1-articleLarge.jpg",
                     "Arts",
                     "",
                     "For TEFAF, a New Year Brings a New Approach",
                     27/02/2020,
                     "https://www.nytimes.com/2020/02/27/arts/tefaf-maastricht.html"),
                     UtilsForArticleSearch.generateArticlesFromArticleSearch("banana", "business", 20200227, 20200227));
                     
                                     getResponseOfTopStories(section)
                                                                                                                                      .enqueue(new Callback<ResponseOfTopStories>() {
                                                                                                                                          @Override
                                                                                                                                          public void onResponse(Call<ResponseOfTopStories> call,
                                                                                                                                                                 Response<ResponseOfTopStories> response) {
                                                                                                                                              if (response.isSuccessful()) {
                                                                                                                                                  topStories.setValue(UtilsForTopStories.generateArticlesFromTopStories(response.body()));
                UtilsForArticleSearch.generateArticlesFromArticleSearch().get(0).getUrlImage());
    }*/
}

