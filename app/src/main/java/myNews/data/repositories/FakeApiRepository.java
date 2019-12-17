package myNews.data.repositories;

import java.util.List;

import myNews.data.repositories.model.Articles;
import myNews.data.service.fakeAPI.FakeApiServiceInterface;

/**
 * Created by Remy Pouzet on 25/11/2019.
 */
public class FakeApiRepository
{
    private final FakeApiServiceInterface mFakeApiServiceInterface;

    public FakeApiRepository(FakeApiServiceInterface fakeApiServiceInterface)
    {
        this.mFakeApiServiceInterface = fakeApiServiceInterface;
    }

    public List<Articles> getArticles()
    {
        return mFakeApiServiceInterface.getArticles();



    }
}