package myNews.view.activitiesAndFragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

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
	
	public static final String PREFS = "PREFS", PREF_KEY_BEGIN_DATE = "PREF_KEY_BEGIN_DATE", PREF_KEY_FILTER = "PREF_KEY_FILTER", PREF_KEY_QUERY = "PREF_KEY_QUERY";
	@BindView(R.id.toolbar) public                     Toolbar      toolbar;
	@BindView(R.id.fragment_main_recycler_view) public RecyclerView recyclerView;
	public                                             String       query, filter, beginDate, endDate;
	
	
	
	
	//FOR DATA
	private List<Articles>    articles;
	private ArticlesAdapter   adapter;
	private SharedPreferences mPreferences;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_results_activity);
		ButterKnife.bind(this);
		
		this.configureRecyclerView();
		
		mPreferences = getSharedPreferences(PREFS, MODE_PRIVATE);
		toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
		
		configureSearchParameters();
		
		ViewModelMyNewsForSearchArticles viewModelMyNewsForSearchArticles = new ViewModelMyNewsForSearchArticles(query, filter, beginDate, endDate);
		viewModelMyNewsForSearchArticles
				.getNews()
				.observe(this, this::updateList);
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
		if (getIntent().getExtras() != null) {
			Bundle bundle = getIntent().getExtras();
			query     = bundle.getString("query");
			filter    = bundle.getString("filter");
			beginDate = bundle.getString("beginDate");
			endDate   = bundle.getString("endDate");
			//Back arrow
			toolbar.setNavigationOnClickListener(v -> startActivity(new Intent(getApplicationContext(), SearchActivity.class)));
		} else {
			query     = mPreferences.getString(PREF_KEY_QUERY, null);
			filter    = mPreferences.getString(PREF_KEY_FILTER, null);
			beginDate = mPreferences.getString(PREF_KEY_BEGIN_DATE, null);
			//Back arrow
			toolbar.setNavigationOnClickListener(v -> startActivity(new Intent(getApplicationContext(), SetNotificationsActivity.class)));
		}
		if (endDate == null) {
			SimpleDateFormat sdf         = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
			String           currentDate = sdf.format(new Date());
			endDate = currentDate;
		}
		if (beginDate == null) {
			beginDate = "19000101";
		}
	}
	
	public void updateList(List<Articles> articlesList) {
		articles.clear();
		if (articlesList != null) {
			articles.addAll(articlesList);
			if (articlesList.size() == 0) {
				
				AlertDialog.Builder builder = new AlertDialog.Builder(this);
				builder.setCancelable(true);
				builder.setTitle("Information");
				builder.setMessage("Il n'y a aucuns résultats");
				
				builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog,
					                    int which) {
						onBackPressed();
					}
				});
				
				AlertDialog dialog = builder.create();
				dialog.show();
				
				
			}
		} else {
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setCancelable(true);
			builder.setTitle("Information");
			builder.setMessage("BAD_REQUEST");
			
			builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog,
				                    int which) {
					onBackPressed();
				}
			});
			
			AlertDialog dialog = builder.create();
			dialog.show();
			
			
		}
		adapter.notifyDataSetChanged();
	}
}

