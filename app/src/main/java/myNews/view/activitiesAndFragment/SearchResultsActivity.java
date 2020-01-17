package myNews.view.activitiesAndFragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import myNews.data.repositories.model.Articles;
import myNews.myNews.R;
import myNews.view.adaptater.ArticlesAdapter;
import myNews.viewmodel.ViewModelMyNewsForSearchArticles;

/**
 * Created by Remy Pouzet on 13/01/2020.
 */
public class SearchResultsActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    public Toolbar toolbar;
    @BindView(R.id.fragment_main_recycler_view)
    RecyclerView recyclerView;

    // @BindView(R.id.recycler_view_search_results) public  RecyclerView mRecyclerView;

    //FOR DATA
    private List<Articles> articles;
    private ArticlesAdapter adapter;
    private ViewModelMyNewsForSearchArticles mViewModelMyNewsForSearchArticles;

    String query;
    String filter;
    String beginDate;
    String endDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_results_activity);
        ButterKnife.bind(this);


        this.configureRecyclerView();

        Bundle bundle = getIntent().getExtras();
        query = bundle.getString("query");
        filter = bundle.getString("filter");
        beginDate = bundle.getString("beginDate");
        endDate = bundle.getString("endDate");

        //Back arrow
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(v -> startActivity(new Intent(getApplicationContext(), SearchActivity.class)));

        mViewModelMyNewsForSearchArticles = new ViewModelMyNewsForSearchArticles("world", null, "20101010", "20101010"/*query, filter, beginDate, endDate*/);
        mViewModelMyNewsForSearchArticles.getNews().observe(this, this::updateList);
    }


    public void configureRecyclerView() {

        // 3.1 - Reset list
        this.articles = new ArrayList<>();
        // 3.2 - Create adapter passing the list of articles
        this.adapter = new ArticlesAdapter(this.articles);

        // set layout
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // 3.3 - Attach the adapter to the recyclerview to populate items
        this.recyclerView.setAdapter(this.adapter);
    }

    public void updateList(List<Articles> articlesList) {
        articles.clear();
        articles.addAll(articlesList);
        adapter.notifyDataSetChanged();
    }
}

