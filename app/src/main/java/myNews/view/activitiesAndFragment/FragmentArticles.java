package myNews.view.activitiesAndFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import myNews.data.repositories.model.Articles;
import myNews.devexchanges.myNews.R;
import myNews.view.Base.BaseFragment;
import myNews.view.adaptater.ArticlesAdapter;

public class FragmentArticles extends BaseFragment
{
    // FOR DESIGN
    @BindView(R.id.fragment_main_recycler_view)
    RecyclerView recyclerView; // 1 - Declare RecyclerView

    //FOR DATA
    // 2 - Declare list of Articles & Adapter
    private List<Articles> articles;
    private ArticlesAdapter adapter;
    private ViewModel mViewModel;
    /* private ArticlesRepository articlesRepository;*/

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

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        updateListOfArticles();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    // -----------------
    // CONFIGURATION
    // -----------------

    // 3 - Configure RecyclerView, Adapter, LayoutManager & glue it together
    private void configureRecyclerView(){
        // 3.1 - Reset list
        this.articles = new ArrayList<>();

        /* this part of code (commented) was for testing by plain text way the recyclerView*/
        /*Articles test = new Articles("test");
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

    private void updateListOfArticles()
    {
        articles.addAll(articlesRepository.getArticles());
        adapter.notifyDataSetChanged();
    }
}

