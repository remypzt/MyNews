package myNews.view.base;

import androidx.fragment.app.Fragment;

import myNews.data.Injection;
import myNews.data.repositories.FakeApiRepository;
import myNews.data.repositories.NytApiRepository;

/**
 * Created by Remy Pouzet on 25/11/2019.
 */
public class BaseFragment extends Fragment
{
    protected FakeApiRepository mFakeApiRepository;
    protected NytApiRepository mNytApiRepository;

    public BaseFragment()
    {
        if (mFakeApiRepository == null) mFakeApiRepository = Injection.createFakeApiRepository();

        if (mNytApiRepository == null) mNytApiRepository = Injection.createNytApiRepository();

    }

    public FakeApiRepository getFakeApiRepository()
    {
        return mFakeApiRepository;
    }

    public NytApiRepository getNytApiRepository()
    {
        return mNytApiRepository;
    }


}
