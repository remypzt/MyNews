package myNews.data.repositories;

import myNews.data.service.realAPI.NytApiInterfaceService;
import myNews.viewmodel.ViewModelMyNews;

/**
 * Created by Remy Pouzet on 17/12/2019.
 */
public class NytApiRepository
{
    private final NytApiInterfaceService mNytApiInterfaceService;
    ViewModelMyNews mViewModelMyNews;


    public NytApiRepository(NytApiInterfaceService nytApiInterfaceService)
    {
        mNytApiInterfaceService = nytApiInterfaceService;
    }


    private void getCall()
    {
        mViewModelMyNews.displayingAppropriateListOfArticles();
    }


}
