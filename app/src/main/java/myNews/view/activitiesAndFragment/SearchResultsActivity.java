package myNews.view.activitiesAndFragment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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


    //FOR DATA
    private List<Articles> articles;
    private ArticlesAdapter adapter;

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

        configureSearchParameters();

        //Back arrow
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(v -> startActivity(new Intent(getApplicationContext(), SearchActivity.class)));

        ViewModelMyNewsForSearchArticles viewModelMyNewsForSearchArticles = new ViewModelMyNewsForSearchArticles(query, filter, beginDate, endDate);
        viewModelMyNewsForSearchArticles.getNews().observe(this, this::updateList);
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

    public void configureSearchParameters() {
        Bundle bundle = getIntent().getExtras();

        query = bundle.getString("query");
        filter = bundle.getString("filter");
        beginDate = bundle.getString("beginDate");
        endDate = bundle.getString("endDate");

        if (endDate == null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
            String currentDate = sdf.format(new Date());
            endDate = currentDate;
        }
    }

    public void updateList(List<Articles> articlesList) {
        articles.clear();
        if (articlesList != null) {
            articles.addAll(articlesList);
            if (articlesList.size() == 0) {
                Toast.makeText(SearchResultsActivity.this, "Il n'y a aucuns résultats", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(SearchResultsActivity.this, "BAD_REQUEST", Toast.LENGTH_LONG).show();
        }

        adapter.notifyDataSetChanged();
    }
}

