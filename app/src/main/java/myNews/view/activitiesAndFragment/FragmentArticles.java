package myNews.view.activitiesAndFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import myNews.data.repositories.ArticlesRepository;
import myNews.data.repositories.model.Articles;
import myNews.devexchanges.myNews.R;
import myNews.view.adaptater.ArticlesAdapter;

public class FragmentArticles extends Fragment
{

    // FOR DESIGN
    @BindView(R.id.fragment_main_recycler_view)
    RecyclerView recyclerView; // 1 - Declare RecyclerView

    //FOR DATA
    // 2 - Declare list of users (GithubUser) & Adapter
    private List<Articles> articles;
    private ArticlesAdapter adapter;
    private ArticlesRepository articlesRepository;

    public FragmentArticles()
    {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_articles_content, container, false);
        ButterKnife.bind(this, view);
        this.configureRecyclerView(); // - 4 Call during UI creation
        return view;
        /*updateListOfArticles();*/
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /*getArticlesRepository();*/
    }
    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    /*public ArticlesRepository getArticlesRepository(){
        if (articlesRepository == null) articlesRepository = Injection.createArticlesRepository();
        return articlesRepository;
    }*/ //TODO injection didn't work

    // -----------------
    // CONFIGURATION
    // -----------------

    // 3 - Configure RecyclerView, Adapter, LayoutManager & glue it together
    private void configureRecyclerView(){
        // 3.1 - Reset list
        this.articles = new ArrayList<>();
        /* Articles test = new Articles("test");*/
        /*this.articles.add(test);*/
        //TODO why this part of code didn't work for testing my recyclerView

        // 3.2 - Create adapter passing the list of users
        this.adapter = new ArticlesAdapter(this.articles);
        // 3.3 - Attach the adapter to the recyclerview to populate items
        this.recyclerView.setAdapter(this.adapter);
        // 3.4 - Set layout manager to position the items
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }
    // -------------------
    // GET ARTICLES
    // -------------------
/*private void getArticles (){
    Articles test = new Articles("test");
    this.articles.add(test);
}*/


    // -------------------
    // UPDATE UI
    // -------------------

    private void updateListOfArticles(List<Articles> articles)
    {
        articles.addAll(articles);
        adapter.notifyDataSetChanged();
    }
}

