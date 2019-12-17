package myNews.data;

import myNews.data.repositories.FakeApiRepository;
import myNews.data.repositories.NytApiRepository;
import myNews.data.service.fakeAPI.FakeApiService;
import myNews.data.service.realAPI.NytApiService;

/**
 * Created by Remy Pouzet on 25/11/2019.
 */

public class Injection
{
    public static FakeApiRepository createFakeApiRepository()
    {
        return new FakeApiRepository(new FakeApiService());
    }

    public static NytApiRepository createNytApiRepository()
    {

        return new NytApiRepository(new NytApiService());

    }
}