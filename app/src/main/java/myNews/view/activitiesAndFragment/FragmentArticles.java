package myNews.view.activitiesAndFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import myNews.data.repositories.model.Articles;
import myNews.data.service.realAPI.mostPopular.MostPopularCalls;
import myNews.data.service.realAPI.mostPopular.mostPopularPOJO.ResponseOfMostPopular;
import myNews.data.service.realAPI.topStories.TopStoriesCalls;
import myNews.data.service.realAPI.topStories.topStoriesPOJO.ResponseOfTopStories;
import myNews.myNews.R;
import myNews.others.utils.UtilsForMostPopular;
import myNews.others.utils.UtilsForTopStories;
import myNews.view.adaptater.ArticlesAdapter;
import myNews.view.base.BaseFragment;
import myNews.viewmodel.ViewModelMyNews;

public class FragmentArticles extends BaseFragment
{
    // FOR DESIGN
    @BindView(R.id.fragment_main_recycler_view)
    RecyclerView recyclerView; // 1 - Declare RecyclerView

    //FOR DATA
    // 2 - Declare list of Articles & Adapter
    private List<Articles> articles;
    private ArticlesAdapter adapter;
    private static String section;
    private static String query;


    private static String filter;

    private ViewModelMyNews viewModelMyNews;
    private int position;
    // = new myNews.viewmodel.ViewModelMyNews()

    public static void setSection(String section)
    {
        FragmentArticles.section = section;
    }

    public static void setQuery(String query)
    {
        FragmentArticles.query = query;
    }

    public static void setFilter(String filter)
    {
        FragmentArticles.filter = filter;
    }

    /* private ArticlesRepository articlesRepository;*/

    public static FragmentArticles newInstance(int position)
    {
        FragmentArticles fragment = new FragmentArticles();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        assert getArguments() != null;
        this.position = getArguments().getInt("position");
        viewModelMyNews = new ViewModelMyNews(position);

        View view = inflater.inflate(R.layout.fragment_articles_content, container, false);
        ButterKnife.bind(this, view);
        viewModelMyNews.displayingAppropriateListOfArticles();
        this.configureRecyclerView(); // - 4 Call during UI creation
        this.callArticlesFromMostPopular();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        updateListOfArticles();
    }


    @Override
    public void onDestroy()
    {
        super.onDestroy();

    }

    private void callArticlesFromTopStories()
    {
        TopStoriesCalls.fetchTopStoriesResponseArticles(new TopStoriesCalls.Callbacks()
        {
            @Override
            public void onResponse(@Nullable ResponseOfTopStories articles)
            {
                Log.d("Test", "onResponse");
                List<Articles> articlesList = UtilsForTopStories.generateArticlesFromTopStories(articles);
                updateList(articlesList);
            }


            @Override
            public void onFailure()
            {
                Log.d("Test", "onFailure");
            }
        }, section);
    }

    private void callArticlesFromMostPopular()
    {
        MostPopularCalls.fetchMostPopularResponseArticles(new MostPopularCalls.Callbacks()
        {
            @Override
            public void onResponse(@Nullable ResponseOfMostPopular articles)
            {
                Log.d("Test", "onResponse");
                List<Articles> articlesList = UtilsForMostPopular.generateArticlesFromMostPopular(articles);
                updateList(articlesList);
            }


            @Override
            public void onFailure()
            {
                Log.d("Test", "onFailure");
            }
        });
    }

    /*private void callArticlesFromArticleSearch()
    {
        ArticleSearchCalls.fetchArticleSearchResponseArticles(new ArticleSearchCalls.Callbacks()
        {
            @Override
            public void onResponse(@Nullable ResponseOfArticleSearch articles)
            {
                Log.d("Test", "onResponse");
                List<Articles> articlesList = UtilsForArticleSearch.generateArticlesFromArticleSearch(articles);
                updateList(articlesList);
            }


            @Override
            public void onFailure()
            {
                Log.d("Test", "onFailure");
            }
        }, query, filter);
    }*/


    // -----------------
    // CONFIGURATION
    // -----------------

    // 3 - Configure RecyclerView, Adapter, LayoutManager & glue it together
    private void configureRecyclerView()
    {
        // 3.1 - Reset list
        this.articles = new ArrayList<>();

        /* this part of code (commented) was for testing by plain text way the recyclerView
        Articles test = new Articles("test");
        this.articles.add(test);*/

        // 3.2 - Create adapter passing the list of articles
        this.adapter = new ArticlesAdapter(this.articles);
        // 3.3 - Attach the adapter to the recyclerview to populate items
        this.recyclerView.setAdapter(this.adapter);
        // 3.4 - Set layout manager to position the items
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    // -------------------
    // UPDATE UI
    // -------------------

    //updateListOfArticles still in Fragments cause I must call the adapter and I cannot do it in viewmodel
    private void updateListOfArticles()
    {
        articles.addAll(articlesRepository.getArticles());
        adapter.notifyDataSetChanged();
    }

    private void updateList(List<Articles> articlesList)
    {
        articles.clear();
        articles.addAll(articlesList);
        adapter.notifyDataSetChanged();
    }
}

